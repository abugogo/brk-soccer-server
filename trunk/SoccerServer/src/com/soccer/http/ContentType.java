package com.soccer.http;

public enum ContentType {
	JSON("application/json");
	
	private String type;
	private ContentType(String type) {
		this.type = type.toLowerCase();
	}
	
	public String getType() {
		return this.type;
	}
	
	public static ContentType fromType(String type) {
		String lowerType = type.toLowerCase();
		for (ContentType t : ContentType.values()) {
			if (t.type.equals(lowerType)) {
				return t;
			}
		}
		return JSON;
	}
}
