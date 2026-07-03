import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest { 
    
    @Test 
    public void testAssertions() { 
        // 1. Assert equals 
        assertEquals(5, 2 + 3); 
 
        // 2. Assert true 
        assertTrue(5 > 3); 
 
        // 3. Assert false 
        assertFalse(5 < 3); 
 
        // 4. Assert null 
        assertNull(null); 
 
        // 5. Assert not null 
        assertNotNull(new Object()); 
        
        // --- Bonus Assertions ---
        
        // 6. Assert Same (Checks memory address, not just value)
        Object myObject = new Object();
        assertSame(myObject, myObject); 
        
        // 7. Assert Array Equals
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
    } 
}