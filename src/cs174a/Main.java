
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
            /*System.out.println(app.setDate(199,6,26));
            System.out.println(app.createCheckingSavingsAccount(AccountType.INTEREST_CHECKING,"500",4000,"513","Liz","HEll"));
            System.out.println(app.createPocketAccount("501","500",100,"513"));
            System.out.println(app.createCustomer("500","514","Regina","Alameda"));
            System.out.println(app.deposit("500",100));
            System.out.println(app.showBalance("501"));*/
            /*System.out.println(app.createPocketAccount("502","500",100,"513"));
            System.out.println(app.topUp("502",100));
            System.out.println(app.payFriend("501","502",100));
            System.out.println(app.listClosedAccounts());*/



        }
    }

    //!### FINALIZAMOS
}
