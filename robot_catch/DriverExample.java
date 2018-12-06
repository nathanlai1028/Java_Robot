package robot_catch;

public class DriverExample
{

public static void main (String args[]) throws Exception
{

String databaseURL = "jdbc:firebirdsql:localhost/3050:D:\\sysConTest\\TEST.FDB";
 //String databaseURL = "jdbc:firebirdsql:native:localhost/3050:c:/database/employee.gdb";
 //String databaseURL = "jdbc:firebirdsql:local:c:/database/employee.gdb";
 //String databaseURL = "jdbc:firebirdsql:embedded:c:/database/employee.fdb?lc_ctype=WIN1251";
 //String databaseURL = "jdbc:firebirdsql:localhost/3050:/var/lib/firebird/2.5/data/employee.fdb?sql_dialect=3";
 String user = "sysdba";
 String password = "masterkey";
 String driverName = "org.firebirdsql.jdbc.FBDriver";


 java.sql.Driver d = null;
 java.sql.Connection c = null;
 java.sql.Statement s = null;
 java.sql.ResultSet rs = null;


 try {
   int registrationAlternative = 1;
   switch (registrationAlternative) {

   case 1:
       try {
       Class.forName ("org.firebirdsql.jdbc.FBDriver");
     }
     catch (java.lang.ClassNotFoundException e) {
       // A call to Class.forName() forces us to consider this exception :-)...
       System.out.println ("Firebird JCA-JDBC driver not found in class path");
       System.out.println (e.getMessage ());
       return;
     }
     break;
/*
   case 2:
     // There is a bug in some JDK 1.1 implementations, eg. with Microsoft
     // Internet Explorer, such that the implicit driver instance created during
     // class initialization does not get registered when the driver is loaded
     // with Class.forName().
     // See the FAQ at http://java.sun.com/jdbc for more info on this problem.
     // Notice that in the following workaround for this bug, that if the bug
     // is not present, then two instances of the driver will be registered
     // with the driver manager, the implicit instance created by the driver
     // class's static clause and the one created explicitly with newInstance().
     // This alternative should not be used except to workaround a JDK 1.1
     // implementation bug.
     try {
       java.sql.DriverManager.registerDriver (
          (java.sql.Driver) Class.forName ("org.firebirdsql.jdbc.FBDriver").newInstance ()
       );
     }
     catch (java.lang.ClassNotFoundException e) {
       // A call to Class.forName() forces us to consider this exception :-)...
       System.out.println ("Driver not found in class path");
       System.out.println (e.getMessage ());
       return;
     }
     catch (java.lang.IllegalAccessException e) {
       // A call to newInstance() forces us to consider this exception :-)...
       System.out.println ("Unable to access driver constructor, this shouldn't happen!");
       System.out.println (e.getMessage ());
       return;
     }
     catch (java.lang.InstantiationException e) {
       // A call to newInstance() forces us to consider this exception :-)...
       // Attempt to instantiate an interface or abstract class.
       System.out.println ("Unable to create an instance of driver class, this shouldn't happen!");
       System.out.println (e.getMessage ());
       return;
     }
     catch (java.sql.SQLException e) {
       // A call to registerDriver() forces us to consider this exception :-)...
       System.out.println ("Driver manager failed to register driver");
       showSQLException (e);
       return;
     }
     break;

   case 3:
     // Add the Firebird JCA-JDBC driver name to your system's jdbc.drivers property list.
     // The driver manager will load drivers from this system property list.
     // System.getProperties() may not be allowed for applets in some browsers.
     // For applets, use one of the Class.forName() alternatives above.
     java.util.Properties sysProps = System.getProperties ();
     StringBuffer drivers = new StringBuffer ("org.firebirdsql.jdbc.FBDriver");
     String oldDrivers = sysProps.getProperty ("jdbc.drivers");
     if (oldDrivers != null)
       drivers.append (":" + oldDrivers);
     sysProps.put ("jdbc.drivers", drivers.toString ());
     System.setProperties (sysProps);
     break;

   case 4:
     // Advanced: This is a non-standard alternative, and is tied to
     // a particular driver implementation, but is very flexible.
     //
     // It may be possible to configure a driver explicitly, either thru
     // the use of non-standard driver constructors, or non-standard
     // driver "set" methods which somehow tailor the driver to behave
     // differently from the default driver instance.
     // Under this alternative, a driver instance is created explicitly
     // using a driver specific constructor.  The driver may then be
     // tailored differently from the default driver instance which is
     // created automatically when the driver class is loaded by the java class loader.
     // For example, perhaps a driver instance could be created which
     // is to behave like some older version of the driver.
     //
     // d = new org.firebirdsql.jdbc.FBDriver ();
     // DriverManager.registerDriver (d);
     // c = DriverManager.getConnection (...);
     //
     // Since two drivers, with differing behavior, are now registered with
     // the driver manager, they presumably must recognize different jdbc
     // subprotocols.  For example, the tailored driver may only recognize
     // "jdbc:interbase:old_version://...", whereas the default driver instance
     // would recognize the standard "jdbc:interbase://...".
     // There are currently no methods, such as the hypothetical setVersion(),
     // for tailoring an Firebird JCA-JDBC driver so this 4th alternative is academic
     // and not necessary for Firebird JCA-JDBC driver.
     //
     // It is also possible to create a tailored driver instance which
     // is *not* registered with the driver manager as follows
     //
     // d = new org.firebirdsql.jdbc.FBDriver ();
     // c = d.connect (...);
     //
     // this is the most usual case as this does not require differing
     // jdbc subprotocols since the connection is obtained thru the driver
     // directly rather than thru the driver manager.
     d = new org.firebirdsql.jdbc.FBDriver ();
  */
   }

   // At this point the driver should be registered with the driver manager.
   // Try to find the registered driver that recognizes interbase URLs...
   try {
     // We pass the entire database URL, but we could just pass "jdbc:interbase:"
     d = java.sql.DriverManager.getDriver (databaseURL);
     System.out.println ("Firebird JCA-JDBC driver version " +
                         d.getMajorVersion () +
                         "." +
                         d.getMinorVersion () +
                         " registered with driver manager.");
   }
   catch (java.sql.SQLException e) {
     System.out.println ("Unable to find Firebird JCA-JDBC driver among the registered drivers.");
     showSQLException (e);
     return;
   }

   // Advanced info: Class.forName() loads the java class for the driver.
   // All JDBC drivers are required to have a static clause that automatically
   // creates an instance of themselves and registers that instance
   // with the driver manager.  So there is no need to call
   // DriverManager.registerDriver() explicitly unless the driver allows
   // for tailored driver instances to be created (each instance recognizing
   // a different jdbc sub-protocol).

   // Now that Firebird JCA-JDBC driver is registered with the driver manager,
   // try to get a connection to an employee.gdb database on this local machine
   // using one of two alternatives for obtaining connections...
   int connectionAlternative = 1;
   switch (connectionAlternative) {

   case 1:
      try {
       c = java.sql.DriverManager.getConnection (databaseURL, user, password);
       System.out.println ("Connection established.");
     }
     catch (java.sql.SQLException e) {
         e.printStackTrace();
       System.out.println ("Unable to establish a connection through the driver manager.");
       showSQLException (e);
       return;
     }
     break;
     
   case 2:
     // If you're working with a particular driver d, which may or may not be registered,
     // you can get a connection directly from it, bypassing the driver manager...
     try {
       java.util.Properties connectionProperties = new java.util.Properties ();
       connectionProperties.put ("user", user);
       connectionProperties.put ("password", password);
       connectionProperties.put ("lc_ctype", "WIN1251");
       c = d.connect (databaseURL, connectionProperties);
       System.out.println ("Connection established.");
     }
     catch (java.sql.SQLException e) {
         e.printStackTrace();
       System.out.println ("Unable to establish a connection through the driver.");
       showSQLException (e);
       return;
     }
     break;
   }

   // Let's disable the default autocommit so we can undo our changes later...
//   try {
//     c.setAutoCommit (false);
//     System.out.println ("Auto-commit is disabled.");
//   }
//   catch (java.sql.SQLException e) {
//     System.out.println ("Unable to disable autocommit.");
//     showSQLException (e);
//     return;
//   }

   // Now that we have a connection, let's try to get some meta data...
			//   try {
			//     java.sql.DatabaseMetaData dbMetaData = c.getMetaData ();
			//    
			//     // Ok, let's query a driver/database capability
			//     if (dbMetaData.supportsTransactions ())
			//       System.out.println ("Transactions are supported.");
			//     else
			//       System.out.println ("Transactions are not supported.");
			//
			//     // What are the views defined on this database?
			//     java.sql.ResultSet tables = dbMetaData.getTables (null, null, "%", new String[] {"VIEW"});
			//     while (tables.next ()) {
			//       System.out.println (tables.getString ("TABLE_NAME") + " is a view.");
			//     }
			//     tables.close ();
			//   }
			//   catch (java.sql.SQLException e) {
			//     System.out.println ("Unable to extract database meta data.");
			//     showSQLException (e);
			//     // What the heck, who needs meta data anyway ;-(, let's continue on...
			//   }

   // Let's try to submit some static SQL on the connection.
   // Note: This SQL should throw an exception on employee.gdb because
   //       of an integrity constraint violation.  
   try {
     s = c.createStatement ();
     
    // s.executeQuery("select cast('????' as varchar(30) character set win1251) from rdb$database order by 1 collate pxw_cyrl");
     
     s.executeUpdate ("update employee set salary = salary + 10000");
   }
   catch (java.sql.SQLException e) {
       e.printStackTrace();
     System.out.println ("Unable to increase everyone's salary.");
     showSQLException (e);
     // We expected this to fail, so don't return, let's keep going...
   }

   // Let's submit some static SQL which produces a result set.
   // Notice that the statement s is reused with a new SQL string.
   try {
     rs = s.executeQuery ("insert into property(field1) values ( "+"test[0])");
   }
   catch (java.sql.SQLException e) {
     System.out.println ("Unable to submit a static SQL query.");
     showSQLException (e);
     // We can't go much further without a result set, return...
     return;
   }

   // The query above could just as easily have been dynamic SQL,
   // eg. if the SQL had been entered as user input.
   // As a dynamic query, we'd need to query the result set meta data
   // for information about the result set's columns.
//   try {
//     java.sql.ResultSetMetaData rsMetaData = rs.getMetaData ();
//     System.out.println ("The query executed has " +
//                         rsMetaData.getColumnCount () +
//                         " result columns.");
//     System.out.println ("Here are the columns: ");
//     for (int i = 1; i <= rsMetaData.getColumnCount (); i++) {
//       System.out.println (rsMetaData.getColumnName (i) +
//                           " of type " +
//                           rsMetaData.getColumnTypeName (i));
//     }
//   }
//   catch (java.sql.SQLException e) {
//     System.out.println ("Unable to extract result set meta data.");
//     showSQLException (e);
//     // What the heck, who needs meta data anyway ;-(, let's continue on...
//   }

   // Ok, lets step thru the results of the query...
//   try {
//     System.out.println ("Here are the employee's whose salary < $50,000");
//     while (rs.next ()) {
//       System.out.println (rs.getString ("full_name"));
//     }
//   }
//   catch (java.sql.SQLException e) {
//     System.out.println ("Unable to step thru results of query");
//     showSQLException (e);
//     return;
//   }

   // As an exercise to the reader, rewrite this code so that required
   // table structures are created dynamically using executeUpdate() on DDL.
   // In this way the code will be able to run against any database file rather
   // than just a previously setup employee.gdb.
   // Just to get you started, you'll want to define a method something like
   // the following...
   //
   // private static void createTableStructures (java.sql.Connection c) throws java.sql.SQLException
   // {
   //   // Some drivers don't force commit on DDL, Firebird JCA-JDBC driver does,
   //   // see DatabaseMetaData.dataDefinitionCausesTransactionCommit().
   //   // This is not necessary for Firebird JCA-JDBC driver, but may be for other drivers...
   //   c.setAutoCommit (true);
   //
   //   java.sql.Statement s = c.createStatement();
   //
   //   // Drop table EMPLOYEE if it already exists, if not that's ok too.
   //   try { s.executeUpdate ("drop table EMPLOYEE"); } catch (java.sql.SQLException e) {}
   //
   //   // Ok, now that we're sure the table isn't already there, create it...
   //   s.executeUpdate ("create table EMPLOYEE (...)");
   //
   //   // Ok, now populate the EMPLOYEE table...
   //   s.executeUpdate ("insert into EMPLOYEE values (...)");
   //
   //   s.close();
   //   c.setAutoCommit (false);
   // }
   //
 }

 // This finally clause will be executed even if "return" was called in case of any exceptions above.
 finally {
   System.out.println ("Closing database resources and rolling back any changes we made to the database.");

   // Now that we're all finished, let's release database resources.
   try { if (rs!=null) rs.close (); } catch (java.sql.SQLException e) { showSQLException (e); }
   try { if (s!=null) s.close (); } catch (java.sql.SQLException e) { showSQLException (e); }

   // Before we close the connection, let's rollback any changes we may have made.
   try { if (c!=null) c.rollback (); } catch (java.sql.SQLException e) { showSQLException (e); }
   try { if (c!=null) c.close (); } catch (java.sql.SQLException e) { showSQLException (e); }
 }
}

// Display an SQLException which has occured in this application.
private static void showSQLException (java.sql.SQLException e)
{
 // Notice that a SQLException is actually a chain of SQLExceptions,
 // let's not forget to print all of them...
 java.sql.SQLException next = e;
 while (next != null) {
   System.out.println (next.getMessage ());
   System.out.println ("Error Code: " + next.getErrorCode ());
   System.out.println ("SQL State: " + next.getSQLState ());
   next = next.getNextException ();
 }
}
}