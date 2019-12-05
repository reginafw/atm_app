
package cs174a;                         // THE BASE PACKAGE FOR YOUR APP MUST BE THIS ONE.  But you may add subpackages.

// DO NOT REMOVE THIS IMPORT.
import cs174a.Testable.*;

/**
 * This is the class that launches your application.
 * DO NOT CHANGE ITS NAME.
 * DO NOT MOVE TO ANY OTHER (SUB)PACKAGE.
 * There's only one "main" method, it should be defined within this Main class, and its signature should not be changed.
 */
public class Main
{
    /**
     * Program entry point.
     * DO NOT CHANGE ITS NAME.
     * DON'T CHANGE THE //!### TAGS EITHER.  If you delete them your program won't run our tests.
     * No other function should be enclosed by the //!### tags.
     */
    //!### COMENZAMOS
    public static void main( String[] args )
    {
        App app = new App();                        // We need the default constructor of your App implementation.  Make sure such
        // constructor exists.
        String r = app.initializeSystem();
       // We'll always call this function before testing your system.
        if( r.equals( "0" ) )
        {
            //app.exampleAccessToDB();
            //app.dropTables();                // Example on how to connect to the DB.

            // Example tests.  We'll overwrite your Main.main() function with our final tests.
            //r = app.createTables();
            //System.out.println( r );


            //app.createCheckingSavingsAccount(AccountType.INTEREST_CHECKING,"111",1200.39, "9096", "Lizard", "404 goodplace");
            // Another example test.
           //app.dropTables();
            /*app.createTables();
            app.setDate(1998,11,30);*/
            /*app.setDate(1999,11,26);
            app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "001", 2000.00, "600", "Lizard", "123 Goleta" );
            app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "002", 3000.00, "600", "Lizard", "123 Goleta" );
            app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "003", 4000.00, "600", "Lizard", "123 Goleta" );*/
            /*app.setDate(1999,11,27);
            app.deposit("001",1000);
            app.deposit("002",1000);
            app.deposit("003",1000);*/
            /*app.setDate(1999,11,28);
            app.withdrawal("001",1000);
            app.withdrawal("002",1000);
            app.withdrawal("003",1000);*/
            //app.setDate(1999,11,29);
            //app.createPocketAccount("201","001",100.00,"600","Goleta");
            //app.topUp("201",1129.56);
            //app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "003", 1200.56, "700", "Noa", "Disneyworld" );
            //app.createPocketAccount("202","002",10.00,"600","SB");
            //app.withdrawal("002", 18.99);
            //app.deleteClosedAccounts();
            //app.deleteTransactions();
            //app.listTransactions("201");
            //app.createCustomer("001","500","Regina", "Disneyland");
            //app.createCustomer("001","700","Noa", "Disneyworld");
            //app.dropTables();
            //app.createTables();
            //app.populateInitialBalance();
            //app.generateMonthlyStatement("500");
            //app.deposit("003",12000);
            //app.generateDTER();
            //app.SetPin("600",0,2000);
           // app.checkCustomerAmount("700");
            //app.startAtm();
            //app.accountUtility(AccountType.INTEREST_CHECKING,"1234",3000,"700","Alameda");
            //app.wire("003","001",100.00,"600");
            //app.collect("201","001",10.00);
            //app.deposit("001",1.00);
            //app.dropTables();
            //app.createTables();
            //app.entryAvgBalance("002", 1000);
            app.accrueInterest();
            //System.out.println(app.getInterestRateFromType(AccountType.SAVINGS));
           // app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "006", 8000.00, "600", "Lizard", "123 Goleta" );
            //app.setInterestRate(AccountType.INTEREST_CHECKING,0.0025);
        }
    }

    //!### FINALIZAMOS
}
