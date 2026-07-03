import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    // Declare the object(s) to be used across multiple tests
    private ShoppingCart cart;

    // --- SETUP & TEARDOWN ---

    @Before
    public void setUp() {
        // Runs BEFORE every single @Test method.
        // Ensures each test starts with a fresh, predictable state.
        cart = new ShoppingCart();
        cart.addItem("Apple"); // Adding a default item for testing purposes
    }

    @After
    public void tearDown() {
        // Runs AFTER every single @Test method.
        // Used to release resources, close database connections, or clear memory.
        cart.clear();
        cart = null; 
    }

    // --- TESTS USING A-A-A PATTERN ---

    @Test
    public void testAddItem() {
        // 1. ARRANGE: Set up the specific preconditions and inputs for this test
        String newItem = "Banana";
        int expectedItemCount = 2; // Because "Apple" is already in the cart from setUp()

        // 2. ACT: Execute the specific method being tested
        cart.addItem(newItem);

        // 3. ASSERT: Verify the state or output matches your expectations
        assertEquals("Cart should have 2 items", expectedItemCount, cart.getItemCount());
        assertTrue("Cart should contain the new item", cart.contains(newItem));
    }

    @Test
    public void testClearCart() {
        // 1. ARRANGE: We know the cart has 1 item ("Apple") due to the @Before method.
        int expectedEmptyCount = 0;

        // 2. ACT: Clear the cart
        cart.clear();

        // 3. ASSERT: Verify the cart is actually empty
        assertEquals("Cart should have 0 items after clearing", expectedEmptyCount, cart.getItemCount());
        assertFalse("Cart should no longer contain Apple", cart.contains("Apple"));
    }
}