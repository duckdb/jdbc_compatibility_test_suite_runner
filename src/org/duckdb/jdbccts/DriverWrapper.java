package org.duckdb.jdbccts;

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
		Driver driver = null;
		try {
			driver = (Driver) Class.forName("org.duckdb.DuckDBDriver").newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Connection conn = driver.connect("jdbc:duckdb:", null);
		try (Statement s = conn.createStatement()) {
			s.executeUpdate("create table ctstable1 (TYPE_ID int, TYPE_DESC varchar(32))");
			s.executeUpdate("create table ctstable2 (KEY_ID int, COF_NAME varchar(32), PRICE float, TYPE_ID int )");
			s.executeUpdate("create table ctstable3(STRING1 VARCHAR(20), STRING2 VARCHAR(20), STRING3 VARCHAR(20), NUMCOL NUMERIC, FLOATCOL FLOAT, DATECOL DATE, TIMECOL TIME, TSCOL1 DATE, TSCOL2 DATE)");
			s.executeUpdate("create table ctstable4(STRING4 VARCHAR(20), NUMCOL NUMERIC)");
			s.executeUpdate("create table Smallint_Tab (MAX_VAL SMALLINT, MIN_VAL SMALLINT, NULL_VAL SMALLINT NULL)");
			s.executeUpdate("create table Varchar_Tab (COFFEE_NAME VARCHAR(60), NULL_VAL VARCHAR(60) NULL)");
			s.executeUpdate("create table Tinyint_Tab (MAX_VAL SMALLINT, MIN_VAL SMALLINT, NULL_VAL SMALLINT NULL)");
			s.executeUpdate("create table Integer_Tab (MAX_VAL INTEGER, MIN_VAL INTEGER, NULL_VAL INTEGER NULL)");
			s.executeUpdate("create table Real_Tab (MAX_VAL float8, MIN_VAL float8 ,NULL_VAL float8 NULL)");
			s.executeUpdate("create table Float_Tab (MAX_VAL FLOAT8, MIN_VAL FLOAT8, NULL_VAL FLOAT8 NULL)");
			s.executeUpdate("create table Decimal_Tab (MAX_VAL DECIMAL(30,15),MIN_VAL DECIMAL(30,15), NULL_VAL DECIMAL(30,15) NULL) ");
			s.executeUpdate("create table Numeric_Tab (MAX_VAL NUMERIC(30,15), MIN_VAL NUMERIC(30,15), NULL_VAL NUMERIC(30,15) NULL) ");
			s.executeUpdate("create table Char_Tab (COFFEE_NAME CHAR(30), NULL_VAL CHAR(30) NULL) ");
			s.executeUpdate("create table Bit_Tab (MAX_VAL boolean, MIN_VAL boolean, NULL_VAL boolean NULL)");
			s.executeUpdate("create table Double_Tab (MAX_VAL DOUBLE PRECISION, MIN_VAL DOUBLE PRECISION, NULL_VAL DOUBLE PRECISION NULL)");
			s.executeUpdate("create table Bigint_Tab (MAX_VAL bigint, MIN_VAL bigint , NULL_VAL bigint  NULL)");
			s.executeUpdate("create table Longvarchar_Tab (COFFEE_NAME TEXT)");
			s.executeUpdate("create table Longvarcharnull_Tab (NULL_VAL TEXT NULL)");
			s.executeUpdate("create table Date_Tab (MFG_DATE DATE, NULL_VAL DATE NULL)");
			s.executeUpdate("create table Time_Tab (BRK_TIME TIME, NULL_VAL TIME NULL)");
			s.executeUpdate("create table Timestamp_Tab (IN_TIME TIMESTAMP without time zone, NULL_VAL TIMESTAMP  without time zone )");
			s.executeUpdate("create table Binary_Tab (BINARY_VAL BLOB NULL)");
			s.executeUpdate("create table Varbinary_Tab (VARBINARY_VAL BLOB NULL)");
			s.executeUpdate("create table Longvarbinary_Tab (LONGVARBINARY_VAL BLOB NULL)");

		}
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
