package nl.cwi.da.jdbccts;

import com.sun.javatest.Status;
import com.sun.ts.lib.harness.ServiceEETest;
import com.sun.ts.tests.jdbc.ee.connection.connection1.connectionClient1;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta1.dbMetaClient1;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet1.resultSetClient1;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet10.resultSetClient10;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet11.resultSetClient11;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet7.resultSetClient7;
import com.sun.ts.tests.jdbc.ee.stmt.stmt1.stmtClient1;
import com.sun.ts.tests.jdbc.ee.stmt.stmt2.stmtClient2;


public class TestRunner {

	private static void run(ServiceEETest t, String[] args) {
		Status s = t.run(args, System.out, System.err);
		if (!s.isPassed()) {
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {

		run(new stmtClient1(), args);
		run(new stmtClient2(), args);
		run(new dbMetaClient1(), args);
		run(new connectionClient1(), args);
		run(new resultSetClient1(), args);
		run(new resultSetClient7(), args);
		run(new resultSetClient10(), args);
		run(new resultSetClient11(), args);
		
		/*
rsMeta	
	
resultSet14
resultSet17
resultSet18
resultSet41
resultSet45
resultSet47
resultSet49	
	
prepStmt1
prepStmt10
prepStmt11
prepStmt12
prepStmt13
prepStmt14
prepStmt15
prepStmt16
prepStmt2
prepStmt3
prepStmt4
prepStmt5
prepStmt6
prepStmt7
prepStmt8
prepStmt9




*/
		System.exit(0);
	}

}


/*

TODO

batchUpdate


dateTime1
dateTime2
dateTime3

dbMeta1
dbMeta10
dbMeta11
dbMeta12
dbMeta2
dbMeta3
dbMeta4
dbMeta5
dbMeta6
dbMeta7
dbMeta8
dbMeta9

scalar1
scalar2
scalar3
scalar4

batUpdExcept
sqlException

*/
 