package com.flyAway.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flyAway.DBConnection;
import com.flyAway.domain.State;

public class StateMySQLDAO implements StateDAO {

	@Override
	public List<State> getAll() {
		DBConnection db = null;
		List<State> states = null;
		try {
			db = new DBConnection();
			Connection conn = db.getConnection();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM state_list");
			
			states = new ArrayList<>();
			while (rs.next()) {
				State state = new State();
				state.setId(rs.getInt(1));
				state.setName(rs.getString(2));
				states.add(state);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return states;
	}

}
