package com.soccer.services;

import java.io.InputStream;

import com.soccer.actions.images.ImageContentType;
import com.soccer.dal.api.IImageAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.image.IImage;

public class ImageService implements IImageAPI {
	private static ImageService instance = null;
	
	public static ImageService getInstance() {
		synchronized (ImageService.class) {
			if (instance == null) {
				instance = new ImageService();
			}
		}
		return instance;
	}
	
	IImageAPI imageDAL = SqlDBDal.getInst();

	@Override
	public IImage readImage(String id) {
		return this.imageDAL.readImage(id);
	}

	@Override
	public void storeImage(String id, ImageContentType type, InputStream imgStream) {
		this.imageDAL.storeImage(id, type, imgStream);
	}

}
