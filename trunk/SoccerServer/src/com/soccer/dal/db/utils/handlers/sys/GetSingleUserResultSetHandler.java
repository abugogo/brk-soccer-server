package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOUser;

public class GetSingleUserResultSetHandler implements ResultSetHandler<IDAOUser> {

	public static final String QUERY = "SELECT u.id, u.pwd, u.fname, u.lname, u.tel1, u.tel2, u.email, u.bday, u.fb_user, u.occupation, u.address1, u.address2, u.P_img, au.acc as acc FROM ABUGOGO_SOCCER_SYS.Users as u INNER JOIN ABUGOGO_SOCCER_SYS.USERSACC as au ON u.id=au.uid WHERE u.id = ? AND u.pwd = ?";
	private static final GetSingleUserResultSetHandler instance = new GetSingleUserResultSetHandler();
	
	public static GetSingleUserResultSetHandler getInstance() {
		return instance;
	}
	
	@Override
	public IDAOUser handle(ResultSet rslt) throws SQLException {
		IDAOUser u = null;
		if (rslt.next()) {
			u = EntityFactory.createUser(rslt);
			do {
				u.addAccount(rslt.getString("acc"));
			} while(rslt.next());
			return u;
		} else {
			return null;
		}
	}

}
