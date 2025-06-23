// FinancialForecastingDemo.java

/**
 * 🔁 Recursion Explained:
 * Recursion is when a method calls itself to solve smaller versions of a problem.
 * It simplifies problems like tree traversal, factorial, and forecasting.
 * Example: futureValue(year) = futureValue(year - 1) * (1 + growthRate)
 */

public class FinancialForecastingDemo {

    // 🧮 Recursive method to calculate future value (without optimization)
    public static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    // ⚡ Optimized using Memoization (caching)
    public static double forecastMemo(double initialValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return initialValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = forecastMemo(initialValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 10000; // Starting investment
        double growthRate = 0.1;     // 10% annual growth
        int years = 5;

        System.out.println("📈 Financial Forecast using Basic Recursion:");
        double futureVal = forecastRecursive(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: ₹%.2f\n", years, futureVal);

        System.out.println("\n⚡ Financial Forecast using Optimized Recursion (Memoization):");
        double[] memo = new double[years + 1];
        double futureValMemo = forecastMemo(initialValue, growthRate, years, memo);
        System.out.printf("Future value after %d years: ₹%.2f\n", years, futureValMemo);

        System.out.println("\n📊 Time Complexity Analysis:");
        System.out.println("- Recursive: O(n) because it calls itself 'years' times.");
        System.out.println("- With Memoization: Also O(n), but avoids redundant recomputation.");
    }
}

