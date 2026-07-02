public class Logger {

    // 1. Private static instance of itself. 
    // 'volatile' ensures that multiple threads handle the instance correctly during initialization.
    private static volatile Logger instance;

    // 2. Private constructor to prevent instantiation from outside the class.
    private Logger() {
        // Optional safeguard: Protects against instantiation via Java Reflection.
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // 3. Public static method to get the instance (Thread-safe implementation).
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking for performance)
            synchronized (Logger.class) {
                if (instance == null) { // Second check (with locking to ensure single creation)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A utility method to demonstrate logging functionality
    public void log(String message) {
        // In a real application, this might write to a file or standard output
        System.out.println("[LOG] " + message);
    }
}