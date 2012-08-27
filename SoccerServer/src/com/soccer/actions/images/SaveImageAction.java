package com.soccer.actions.images;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.soccer.http.HttpMethod;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.ImageService;

public class SaveImageAction implements RESTAction {

	@SuppressWarnings("unchecked")
	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		String id = null;
		String contentType = null;
		InputStream in = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		try {
			if (!isMultipart) {
				if (path.getMethod() == HttpMethod.PUT) {
					id = path.getPathArray()[1];
				} else {
					id = req.getParameter("id");
				}
				contentType = req.getContentType();
				in = req.getInputStream();
			} else {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = null;
	
				try {
					items = upload.parseRequest(req);
					for (FileItem item : items){
						if (item.isFormField()){
							String name = item.getFieldName();
							System.out.print("name: "+name);
							String value = item.getString();
							System.out.println(" || value: "+value);
							if ("id".equals(name)) {
								id = value;
							}
						} else {
							in = item.getInputStream();
							contentType = item.getContentType();
						}
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
	
			if (id == null || in == null) {
				throw new RuntimeException("not all parameters could be read");
			}
			
			ImageService.getInstance().storeImage(id, ImageContentType.getImageContentType(contentType), in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
