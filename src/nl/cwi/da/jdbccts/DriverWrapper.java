package nl.cwi.da.jdbccts;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

// some hackery going on here
public class DriverWrapper implements Driver {
	
	static {
		try {
			DriverManager.registerDriver(new DriverWrapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect(String url, Properties info) throws SQLException {
		Connection conn = null;
		try {
			conn = ((Driver)Class.forName("nl.cwi.da.duckdb.DuckDBDriver").newInstance()).connect("jdbc:duckdb:", null);
		} catch (Exception e) {
			throw new SQLException(e);
		} 
		Statement s = conn.createStatement();
		s.executeUpdate("create table ctstable1 (TYPE_ID int, TYPE_DESC varchar(32))");
		s.executeUpdate("create table ctstable2 (KEY_ID int, COF_NAME varchar(32), PRICE float, TYPE_ID int )");
		s.executeUpdate("create table Smallint_Tab (MAX_VAL SMALLINT, MIN_VAL SMALLINT, NULL_VAL SMALLINT NULL)");

		

		s.close();
		return conn;
	}

	public boolean acceptsURL(String url) throws SQLException {
		return url.startsWith("jdbc:wrap:");
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public int getMajorVersion() {
		return 1;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
