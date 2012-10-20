package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.ITableRow;

public interface ITableAPI {
	List<ITableRow> getPlayersTable();
}
