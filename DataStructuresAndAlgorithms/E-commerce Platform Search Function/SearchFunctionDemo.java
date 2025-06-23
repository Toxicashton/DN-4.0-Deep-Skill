// SearchFunctionDemo.java

import java.util.Arrays;
import java.util.Scanner;

/**
 * Big O Notation:
 * - Describes how the performance (time or space) of an algorithm scales with input size.
 * - Best Case: Fastest time possible (e.g., item found at start)
 * - Average Case: Typical performance over all inputs
 * - Worst Case: Slowest scenario (e.g., item at end or not found)
 *
 * Linear Search: O(n) time complexity
 * Binary Search: O(log n) time complexity (only works on sorted data)
 */

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class SearchFunctionDemo {

    // Linear Search: O(n)
    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    // Binary Search: O(log n), assuming sorted by productId
    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample product data
        Product[] products = {
            new Product(105, "Phone", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(110, "Book", "Stationery"),
            new Product(101, "Laptop", "Electronics"),
            new Product(108, "Shoes", "Footwear")
        };

        // For binary search, sort array by productId
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (a, b) -> Integer.compare(a.productId, b.productId));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID to search: ");
        int searchId = sc.nextInt();

        System.out.println("\n🔍 Linear Search Result:");
        Product result1 = linearSearch(products, searchId);
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n⚡ Binary Search Result:");
        Product result2 = binarySearch(sortedProducts, searchId);
        System.out.println(result2 != null ? result2 : "Product not found");

        System.out.println("\n📊 Time Complexity Comparison:");
        System.out.println("Linear Search: O(n) - good for small or unsorted datasets");
        System.out.println("Binary Search: O(log n) - efficient but needs sorted data");

        sc.close();
    }
}
