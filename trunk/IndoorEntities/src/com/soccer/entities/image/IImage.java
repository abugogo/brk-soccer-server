package com.soccer.entities.image;

import java.io.InputStream;

public interface IImage {
	public String getId();
	public String getMimeType();
	public InputStream getImage();
}
