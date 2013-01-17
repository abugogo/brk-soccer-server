package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.impl.TableRow;

public interface ITableAPI {
	List<TableRow> getPlayersTable(String schema);
}
