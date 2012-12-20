package com.soccer.actions.table;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.ITableRow;
import com.soccer.entities.impl.TableRow;
import com.soccer.http.ContentType;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.TableService;

public class GetTableAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
//			String startDateStr = req.getParameter("startDate");
//			if (startDateStr != null) {
//				
//			}
			List<TableRow> table = TableService.getInstance().getPlayersTable();
			EntityManager.writeTableToStream(table, resp.getOutputStream());
			resp.setContentType(ContentType.JSON.getType());
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
