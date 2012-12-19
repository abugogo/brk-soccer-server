package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.image.IImage;
import com.soccer.entities.image.impl.Image;

public class GetIImageResultHandler implements ResultSetHandler<IImage> {

	public static final String QUERY = "SELECT id, mime_type, image FROM images WHERE id = ?";
	private static final GetIImageResultHandler instance = new GetIImageResultHandler();
	
	public static GetIImageResultHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return QUERY;
	}

	@Override
	public IImage handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return new Image(rslt.getString("id"), rslt.getString("mime_type"), rslt.getBinaryStream("image"));
		}

		return null;
	}

}
