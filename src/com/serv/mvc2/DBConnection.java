package com.serv.mvc2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.PooledConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class DBConnection {

	public Connection dbConnection() throws SQLException {
		Connection myconn = null;
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		ds.setURL("jdbc:oracle:thin:@localhost:1521:ORCL");
		ds.setUser("system");
		ds.setPassword("sadmin@12");
		PooledConnection pc = ds.getPooledConnection();
		myconn = ds.getConnection();
		return myconn;
	}
}
