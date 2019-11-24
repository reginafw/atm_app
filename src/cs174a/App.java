package cs174a;                                             // THE BASE PACKAGE FOR YOUR APP MUST BE THIS ONE.  But you may add subpackages.

// You may have as many imports as you need.
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;

/**
 * The most important class for your application.
 * DO NOT CHANGE ITS SIGNATURE.
 */
public class App implements Testable
{
    private OracleConnection _connection;                   // Example connection object to your DB.

    /**
     * Default constructor.
     * DO NOT REMOVE.
     */
    App()
    {
        // TODO: Any actions you need.
    }

    /**
     * This is an example access operation to the DB.
     */
    void exampleAccessToDB()
    {
        // Statement and ResultSet are AutoCloseable and closed automatically.
        try( Statement statement = _connection.createStatement() )
        {
            try( ResultSet resultSet = statement.executeQuery( "select owner, table_name from all_tables" ) )
            {
                while( resultSet.next() )
                    System.out.println( resultSet.getString( 1 ) + " " + resultSet.getString( 2 ) + " " );
            }
        }
        catch( SQLException e )
        {
            System.err.println( e.getMessage() );
        }
    }

    ////////////////////////////// Implement all of the methods given in the interface /////////////////////////////////
    // Check the Testable.java interface for the function signatures and descriptions.

    @Override
    public String initializeSystem()
    {
        // Some constants to connect to your DB.
        final String DB_URL = "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/orcl";
        final String DB_USER = "c##rweinreb";
        final String DB_PASSWORD = "5379052";

        // Initialize your system.  Probably setting up the DB connection.
        Properties info = new Properties();
        info.put( OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER );
        info.put( OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD );
        info.put( OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20" );

        try
        {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL( DB_URL );
            ods.setConnectionProperties( info );
            _connection = (OracleConnection) ods.getConnection();

            // Get the JDBC driver name and version.
            DatabaseMetaData dbmd = _connection.getMetaData();
            System.out.println( "Driver Name: " + dbmd.getDriverName() );
            System.out.println( "Driver Version: " + dbmd.getDriverVersion() );

            // Print some connection properties.
            System.out.println( "Default Row Prefetch Value is: " + _connection.getDefaultRowPrefetch() );
            System.out.println( "Database Username is: " + _connection.getUserName() );
            System.out.println();

            return "0";
        }
        catch( SQLException e )
        {
            System.err.println( e.getMessage() );
            return "1";
        }
    }


    /**
     * Destroy all of the tables in your DB.
     * @return a string "r", where r = 0 for success, 1 for error.
     */
    public String dropTables()
    {
        try (Statement statement = _connection.createStatement()) {
            statement.executeUpdate("DROP TABLE Transaction_Performed");
            statement.executeUpdate("DROP TABLE Co_owns");
            statement.executeUpdate("DROP TABLE Pocket");
            statement.executeUpdate("DROP TABLE Closed");
            statement.executeUpdate("DROP TABLE Account_Owns");
            statement.executeUpdate("DROP TABLE Customer");
            statement.executeUpdate("DROP TABLE Current_Date");
            return "0";
        }
        catch( SQLException e )
        {
            System.err.println( e.getMessage() );
            return "1";
        }
    }

    /**
     * Create all of your tables in your DB.
     * @return a string "r", where r = 0 for success, 1 for error.
     */
    public String createTables()
    {
        String createCustomer = "CREATE TABLE Customer(" +
                "name VARCHAR(100)," +
                "taxid VARCHAR(100)," +
                "address VARCHAR(100)," +
                "PIN INTEGER," +
                "PRIMARY KEY(taxid))";

        String createAccount_Owns = "CREATE TABLE Account_Owns("+
                "aid VARCHAR(100), "+
                "branch VARCHAR(100),"+
                "acc_type VARCHAR(100), "+
                "balance REAL, "+
                "interest_rate  REAL, "+
                "interest REAL, "+
                "taxid VARCHAR(100) NOT NULL,"+
                "PRIMARY KEY(aid),"+
                "FOREIGN KEY(taxid) REFERENCES Customer(taxid))";

        String createTransaction_Performed =" CREATE TABLE Transaction_Performed("+
                "tid VARCHAR(100), "+
                "tdate DATE, "+
                "trans_type VARCHAR(100),"+
                "amount REAL,"+
                "tfee REAL,"+
                "checknum INTEGER,"+
                "acc_to VARCHAR(100) NOT NULL,"+
                "acc_from VARCHAR(100),"+
                "PRIMARY KEY(tid),"+
                "FOREIGN KEY(acc_to) REFERENCES Account_Owns(aid), "+
                "FOREIGN KEY(acc_from) REFERENCES Account_Owns(aid))";

        String createCo_owns= "CREATE TABLE Co_owns("+
                "aid VARCHAR(100),"+
                "taxid VARCHAR(100),"+
                "PRIMARY KEY (aid, taxid),"+
                "FOREIGN KEY(aid) REFERENCES Account_Owns(aid),"+
                "FOREIGN KEY (taxid) REFERENCES Customer(taxid))";

        String createPocket = "CREATE TABLE Pocket("+
                "paid VARCHAR(100),"+
                "aid VARCHAR(100) NOT NULL,"+
                "pocket_fee REAL,"+
                "PRIMARY KEY(paid),"+
                "FOREIGN KEY(paid) REFERENCES Account_Owns(aid) ON DELETE CASCADE," +
                "FOREIGN KEY(aid) REFERENCES Account_Owns(aid))";

        String createDate = "CREATE TABLE Current_Date("+
                "cdate DATE,"+
                "PRIMARY KEY (cdate))";

        String createClosed = "CREATE TABLE Closed("+
                "aid VARCHAR(100),"+
                "PRIMARY KEY(aid),"+
                "FOREIGN KEY(aid) REFERENCES Account_Owns(aid))";

        try (Statement statement = _connection.createStatement()) {
            statement.executeUpdate(createCustomer);
            statement.executeUpdate(createAccount_Owns);
            statement.executeUpdate(createPocket);
            statement.executeUpdate(createCo_owns);
            statement.executeUpdate(createTransaction_Performed);
            statement.executeUpdate(createClosed);
            statement.executeUpdate(createDate);
            return "0";
        }
        catch( SQLException e )
        {
            System.err.println( e.getMessage() );
            return "1";
        }
    }

    public String setDate( int year, int month, int day ){
        String clear = "DELETE FROM Current_Date";
        //if table is full
        try (Statement statement = _connection.createStatement()) {
            try (ResultSet resultSet = statement
                    .executeQuery("SELECT cdate FROM Current_Date")) {
                if(resultSet.next())
                    System.out.println(resultSet.getString(1));
                    statement.executeUpdate(clear);
            }
        } catch( SQLException e){
            System.err.println( e.getMessage() );
            return "1";
        }
        String insertDate = "INSERT INTO Current_Date (cdate) VALUES(?)";
        LocalDate currentDate = LocalDate.of(year,month, day);
        try (PreparedStatement statement = _connection.prepareStatement(insertDate)) {
            statement.setDate(1,java.sql.Date.valueOf(currentDate));
            statement.executeUpdate();
            return "r yyyy-mm-dd";
        }
        catch( SQLException e )
        {
            System.err.println( e.getMessage() );
            return "1";
        }

    }



}