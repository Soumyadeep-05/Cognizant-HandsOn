public class SingletonTest {
    
    public static void main(String[] args) {
        System.out.println("Starting Singleton Pattern Test...\n");

        // Attempting to create two separate logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Using both variables to log messages
        logger1.log("Application started successfully.");
        logger2.log("Processing user data...");

        // Verifying that both variables point to the exact same memory location
        System.out.println("\n--- Instance Verification ---");
        System.out.println("Memory address of logger1: " + logger1.hashCode());
        System.out.println("Memory address of logger2: " + logger2.hashCode());

        // The '==' operator checks if both references point to the same object in memory
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 share the exact same instance.");
        } else {
            System.out.println("\nFAILURE: logger1 and logger2 are different instances.");
        }
        
        /* * Note: Attempting to do the following will result in a compilation error,
         * proving the constructor is successfully hidden:
         * Logger logger3 = new Logger(); 
         */
    }
}