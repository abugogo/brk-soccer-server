package test.http.rest.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class ImageTester {

	@Test
	public void test() {
		OutputStream out = null;
		InputStream in = null;
		try {
			// Send data
			URL url = new URL(
					"http://localhost:8080/SoccerServer/rest/images/zzzzhf439gf9439g4");
			HttpURLConnection httpCon = (HttpURLConnection) url
					.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			out = httpCon.getOutputStream();
			in = new FileInputStream(new java.io.File(
					"C:\\Users\\user\\Downloads\\hyundai.jpg"));

			byte[] buff = new byte[1024];
			int read;

			while ((read = in.read(buff)) != -1) {
				out.write(buff, 0, read);
			}

			// Get the response
			httpCon.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
