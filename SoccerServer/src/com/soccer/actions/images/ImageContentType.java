package com.soccer.actions.images;

public enum ImageContentType {
	JGP("image/jpeg", "jpg"), JGEP("image/jpeg", "jpeg"), PNG("image/png", "png"), GIF("image/gif", "gif");
	
	private String contentType;
	private String search;

	private ImageContentType(String contentType, String search) {
		this.contentType = contentType;
		this.search = search;
	}
	
	public static ImageContentType getImageContentType(String contentType) {
		if (contentType == null) {
			return ImageContentType.JGP;
		}
		
		for (ImageContentType type : ImageContentType.values()) {
			if (contentType.contains(type.search)) {
				return type;
			}
		}
		
		return ImageContentType.JGP;
	}
	
	public String getContentType() {
		return this.contentType;
	}
}
