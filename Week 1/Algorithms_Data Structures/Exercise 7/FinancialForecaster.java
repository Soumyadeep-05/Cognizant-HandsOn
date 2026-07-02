import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    // Base historical data
    private final double monthZeroValue = 10000.00;
    private final double monthOneValue = 10200.00;

    /**
     * NAIVE RECURSION: 
     * Predicts the future value but recalculates overlapping subproblems.
     */
    public double predictNaive(int month) {
        // Base Cases
        if (month == 0) return monthZeroValue;
        if (month == 1) return monthOneValue;

        // Recursive Case: V(n) = (V(n-1) * 1.05) + (V(n-2) * 0.02)
        return (predictNaive(month - 1) * 1.05) + (predictNaive(month - 2) * 0.02);
    }

    /**
     * OPTIMIZED RECURSION (Memoization): 
     * Stores previously calculated months in a map to avoid redundant calculations.
     */
    public double predictOptimized(int month, Map<Integer, Double> memo) {
        // Base Cases
        if (month == 0) return monthZeroValue;
        if (month == 1) return monthOneValue;

        // Check if we have already calculated this month's value
        if (memo.containsKey(month)) {
            return memo.get(month);
        }

        // Recursive Case: Calculate and store in the memo before returning
        double projectedValue = (predictOptimized(month - 1, memo) * 1.05) + 
                                (predictOptimized(month - 2, memo) * 0.02);
        
        memo.put(month, projectedValue);
        return projectedValue;
    }

    // --- Testing the Implementation ---
    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();
        int targetMonth = 30; // Forecasting 30 months into the future

        System.out.println("Starting Forecast Generation...\n");

        // 1. Optimized Approach
        long startTimeOpt = System.nanoTime();
        Map<Integer, Double> memo = new HashMap<>();
        double optResult = forecaster.predictOptimized(targetMonth, memo);
        long endTimeOpt = System.nanoTime();
        
        System.out.printf("Optimized Forecast (Month %d): $%,.2f\n", targetMonth, optResult);
        System.out.println("Time taken: " + (endTimeOpt - startTimeOpt) + " nanoseconds\n");

        // 2. Naive Approach
        long startTimeNaive = System.nanoTime();
        double naiveResult = forecaster.predictNaive(targetMonth);
        long endTimeNaive = System.nanoTime();
        
        System.out.printf("Naive Forecast (Month %d): $%,.2f\n", targetMonth, naiveResult);
        System.out.println("Time taken: " + (endTimeNaive - startTimeNaive) + " nanoseconds\n");
    }
}