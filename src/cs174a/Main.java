
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
        System.out.println("hello");
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
            //app.setDate(1998,07,26);
            //app.createCheckingSavingsAccount(AccountType.INTEREST_CHECKING,"111",1200.39, "9096", "Lizard", "404 goodplace");
            // Another example test.
            //app.checkPocketTransaction("77777");
            //app.createCustomer("1235", "2626", "Regina", "68 DP");
            //app.tester();
            //app.setDate(1998,05,05);
            //if(app.checkPocketTransaction("332")==true)
                //System.out.println("transaction happened");
            //if(app.checkPocketTransaction("332")==false)
                //System.out.println("transaction did not happen");
            app.payFriend("1000","999", 10.99);
            //app.topUp("999",100.00);
            //r = app.createCheckingSavingsAccount( AccountType.INTEREST_CHECKING, "account1", 1234.56, "theTaxID", "Im YoungMing", "Known" );
        }
    }

    //!### FINALIZAMOS
}
