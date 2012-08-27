package com.soccer.entities.image.impl;

import com.soccer.entities.image.IImage;
import java.io.InputStream;


public class Image implements IImage {
	private String id;
	private String mimeType;
	private InputStream img;

	public Image(String id, String mimeType, InputStream img) {
		this.id = id;
		this.mimeType = mimeType;
		this.img = img;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getMimeType() {
		return this.mimeType;
	}

	@Override
	public InputStream getImage() {
		return this.img;
	}
}
