import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Standard initialization of the SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("Starting application...\n");

        // 1. Basic Logging (Your implementation)
        logger.error("This is an error message.");
        logger.warn("This is a warning message.");
        logger.info("This is an informational message.");

        System.out.println("\n--- Parameterized Logging Example ---");

        // 2. Parameterized Logging (Best Practice)
        String user = "admin";
        int failedAttempts = 3;

        // The {} placeholders are replaced by the variables in order
        logger.warn("User '{}' has failed login {} times.", user, failedAttempts);
        
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // SLF4J allows you to pass the exception as the last argument to print the stack trace
            logger.error("A critical calculation failed!", e);
        }
    }
}