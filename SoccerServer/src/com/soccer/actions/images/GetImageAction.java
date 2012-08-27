package com.soccer.actions.images;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.image.IImage;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.ImageService;

public class GetImageAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		IImage img = ImageService.getInstance().readImage(path.getPathArray()[1]);
		resp.setContentType(img.getMimeType());
		try {
			OutputStream out = resp.getOutputStream();
			InputStream in = img.getImage();
			
			byte[] buff = new byte[1024];
			int read;
			while ((read = in.read(buff)) != -1) {
				out.write(buff, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
