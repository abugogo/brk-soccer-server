package com.soccer.entities.image;

import java.io.InputStream;

public interface IImage {
	String getId();
	String getMimeType();
	InputStream getImage();
}
