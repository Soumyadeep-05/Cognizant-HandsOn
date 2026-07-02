import java.util.Arrays;

public class SearchEngine {

    /**
     * Linear Search: Iterates through every element one by one.
     * Does NOT require the array to be sorted.
     */
    public static Product linearSearch(Product[] catalog, int targetId) {
        for (Product product : catalog) {
            if (product.getProductId() == targetId) {
                return product; // Found
            }
        }
        return null; // Not found
    }

    /**
     * Binary Search: Divides the search space in half each iteration.
     * REQUIRES the array to be sorted beforehand.
     */
    public static Product binarySearch(Product[] sortedCatalog, int targetId) {
        int left = 0;
        int right = sortedCatalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = sortedCatalog[mid];

            if (midProduct.getProductId() == targetId) {
                return midProduct; // Found
            }
            
            if (midProduct.getProductId() < targetId) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Not found
    }

    // --- Testing the Implementation ---
    public static void main(String[] args) {
        Product[] catalog = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(109, "Desk Mat", "Accessories"),
            new Product(102, "Monitor Stand", "Accessories"),
            new Product(107, "USB-C Hub", "Electronics")
        };

        int targetId = 107;

        // 1. Linear Search (Works on unsorted data)
        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(catalog, targetId);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not found"));

        // 2. Binary Search (Requires sorting first)
        System.out.println("\n--- Binary Search ---");
        Arrays.sort(catalog); // Sorting takes O(N log N) time
        Product foundBinary = binarySearch(catalog, targetId);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not found"));
    }
}