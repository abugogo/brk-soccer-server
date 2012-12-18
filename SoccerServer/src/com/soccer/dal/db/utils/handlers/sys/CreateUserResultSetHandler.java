package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOUser;

public class CreateUserResultSetHandler implements ResultSetHandler<IDAOUser> {

	public static final String QUERY = "INSERT INTO abugogo_soccer_sys.users " +
			"(id, pwd, fname, accounts, lname, " +
			"tel1, tel2, email, bday, fb_user, " +
			"occupation, address1, address2, " +
			"P_img, salt) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final CreateUserResultSetHandler instance = new CreateUserResultSetHandler();
	
	public static CreateUserResultSetHandler getInstance() {
		return instance;
	}
	
	@Override
	public IDAOUser handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createUser(rslt);
		} else {
			return null;
		}
	}

}
