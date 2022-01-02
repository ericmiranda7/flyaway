package com.flyAway.actions;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyAway.DBConnection;

public abstract class AbstractAction implements Action {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected DBConnection db;
	protected Connection conn;

	public AbstractAction(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.db = null;
		this.conn = null;
	}

}
