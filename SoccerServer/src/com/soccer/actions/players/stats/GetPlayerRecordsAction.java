package com.soccer.actions.players.stats;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.impl.DAOAggrLEvents;
import com.soccer.http.ContentType;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

public class GetPlayerRecordsAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			String playerId = path.getPathArray()[1];
			SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd");
			Date sdate, edate;
			String sStartDate = req.getParameter("sdate");
			String sEndDate = req.getParameter("edate");
			
			if(sStartDate != null && !sStartDate.isEmpty()) {
				sdate = (sd.parse(sStartDate));
			}
			else
				sdate = sd.parse("1970-01-01");
			if(sEndDate != null && !sEndDate.isEmpty()) {
				edate = (sd.parse(sEndDate));
			}
			else
				edate = sd.parse(sd.format(new Date()));
			
			List<DAOAggrLEvents> records = SoccerService.getInstance().getPlayerRecords(playerId, sdate, edate);
			EntityManager.writePlayerRecords(records, resp.getOutputStream());
			resp.setContentType(ContentType.JSON.getType());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
