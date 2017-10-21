package nz.govt.msd.driver.http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;

import com.google.common.net.MediaType;

/**
 * Attach a File or data to an http request. 
 * 
 * @author Andrew Sumner
 */
class RawDataWriter implements DataWriter {
	private HttpURLConnection connection;
	private byte[] postEndcoded = null;
	private File uploadFile = null;
	
	/**
	 * Constructor.
	 * 
	 * @param connection The connection
	 * @param rawData data (File or String)
	 * @param rawDataMediaType Type of attachment
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public RawDataWriter(HttpURLConnection connection, Object rawData, MediaType rawDataMediaType) {
		this.connection = connection;
		
		if (rawData instanceof File) {
			uploadFile = (File)rawData;
			
			connection.setRequestProperty("Content-Type", rawDataMediaType.toString());
			connection.setRequestProperty("Content-Length", Long.toString(uploadFile.length()));
		} else {
			// Assume data is encoded correctly
			//this.postEndcoded = rawData.getBytes(URLEncoder.encode(String.valueOf(data), "UTF-8"));
			this.postEndcoded = String.valueOf(rawData).getBytes(StandardCharsets.UTF_8);
			
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Type", rawDataMediaType.toString());
			connection.setRequestProperty("Content-Length", Integer.toString(postEndcoded.length));
		}
	}

	@Override
	public void write(Logger logger) throws IOException {

		StringBuilder logBuffer = null;

		if (logger != null) {
			logBuffer = new StringBuilder();
		}

		if (uploadFile == null) {
			if (logBuffer != null) {
				logBuffer.append(postEndcoded);
			}

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postEndcoded);
			}
		} else {
			OutputStream outputStream = connection.getOutputStream();
			
			try (FileInputStream inputStream = new FileInputStream(uploadFile)) {
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				if (logBuffer != null) {
					logBuffer.append("... Content of file ").append(uploadFile.getAbsolutePath()).append(" ...").append(System.lineSeparator());
				}

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.flush();
			}
		}

		if (logger != null) {
			logger.trace("With Content:{}\t{}", System.lineSeparator(), logBuffer);
		}
	}
	
}
