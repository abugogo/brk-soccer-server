package com.soccer.dal.api;

import java.io.InputStream;

import com.soccer.actions.images.ImageContentType;
import com.soccer.entities.image.IImage;

public interface IImageAPI {
	IImage readImage(String id);
	void storeImage(String id, ImageContentType type, InputStream imgStream);
}
