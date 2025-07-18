package org.duckdb.jdbccts;

import com.sun.javatest.Status;
import com.sun.ts.lib.harness.ServiceEETest;
import com.sun.ts.tests.jdbc.ee.batchUpdate.batchUpdateClient;
import com.sun.ts.tests.jdbc.ee.connection.connection1.connectionClient1;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta1.dbMetaClient1;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta2.dbMetaClient2;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta3.dbMetaClient3;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta4.dbMetaClient4;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta5.dbMetaClient5;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta6.dbMetaClient6;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta7.dbMetaClient7;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta8.dbMetaClient8;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta9.dbMetaClient9;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta10.dbMetaClient10;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta11.dbMetaClient11;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta12.dbMetaClient12;
import com.sun.ts.tests.jdbc.ee.exception.batUpdExcept.batUpdExceptClient;
import com.sun.ts.tests.jdbc.ee.exception.sqlException.sqlExceptionClient;

import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt1.prepStmtClient1;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt10.prepStmtClient10;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt11.prepStmtClient11;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt12.prepStmtClient12;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt13.prepStmtClient13;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt14.prepStmtClient14;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt15.prepStmtClient15;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt16.prepStmtClient16;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt2.prepStmtClient2;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt3.prepStmtClient3;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt4.prepStmtClient4;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt5.prepStmtClient5;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt6.prepStmtClient6;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt7.prepStmtClient7;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt8.prepStmtClient8;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt9.prepStmtClient9;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet1.resultSetClient1;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet10.resultSetClient10;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet11.resultSetClient11;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet14.resultSetClient14;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet17.resultSetClient17;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet18.resultSetClient18;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet41.resultSetClient41;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet45.resultSetClient45;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet47.resultSetClient47;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet49.resultSetClient49;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet7.resultSetClient7;
import com.sun.ts.tests.jdbc.ee.rsMeta.rsMetaClient;
import com.sun.ts.tests.jdbc.ee.stmt.stmt1.stmtClient1;
import com.sun.ts.tests.jdbc.ee.stmt.stmt2.stmtClient2;
import com.sun.ts.tests.jdbc.ee.stmt.stmt3.stmtClient3;


public class TestRunner {

	private static void run(ServiceEETest t, String[] args) {
		Status s = t.run(args, System.out, System.err);
		if (!s.isPassed()) {
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {

		run(new batchUpdateClient(), args);

		run(new connectionClient1(), args);

		run(new dbMetaClient1(), args);
		run(new dbMetaClient2(), args);
		run(new dbMetaClient3(), args);
		run(new dbMetaClient4(), args);
		run(new dbMetaClient5(), args);
		run(new dbMetaClient6(), args);
		run(new dbMetaClient7(), args);
		run(new dbMetaClient8(), args);
		run(new dbMetaClient9(), args);
		// run(new dbMetaClient10(), args);
		run(new dbMetaClient11(), args);
		run(new dbMetaClient12(), args);

		// todo: escapeSyntax
		run(new batUpdExceptClient(), args);

		run(new sqlExceptionClient(), args);

		run(new prepStmtClient1(), args);
		run(new prepStmtClient2(), args);
		run(new prepStmtClient3(), args);
		run(new prepStmtClient4(), args);
		run(new prepStmtClient5(), args);
		run(new prepStmtClient6(), args);
		run(new prepStmtClient7(), args);
		run(new prepStmtClient8(), args);
		run(new prepStmtClient9(), args);
		run(new prepStmtClient10(), args);
		run(new prepStmtClient11(), args);
		run(new prepStmtClient12(), args);
		run(new prepStmtClient13(), args);
		run(new prepStmtClient14(), args);
		run(new prepStmtClient15(), args);
		run(new prepStmtClient16(), args);

		run(new resultSetClient1(), args);
		run(new resultSetClient7(), args);
		run(new resultSetClient10(), args);
		run(new resultSetClient11(), args);
		run(new resultSetClient14(), args);
		run(new resultSetClient17(), args);
		run(new resultSetClient18(), args);
		run(new resultSetClient41(), args);
		run(new resultSetClient45(), args); 
		run(new resultSetClient47(), args); // varbinary stuff
		run(new resultSetClient49(), args); // time & timestamps

		// special snowflake rsMetaClient has a bug that expects ftable to be ctstable2
		String[] args_meta = new String[args.length+1];
		for (int i = 0; i < args.length; i++) {
			args_meta[i] = args[i];
		}
		args_meta[args_meta.length-1] = "-dftable=ctstable2";
		run(new rsMetaClient(), args_meta);

		run(new stmtClient1(), args);
		run(new stmtClient2(), args);
		run(new stmtClient3(), args);
		
		System.exit(0);
	}

}
