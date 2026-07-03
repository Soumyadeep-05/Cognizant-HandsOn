import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Tells JUnit 5 to enable Mockito annotations for this class
@ExtendWith(MockitoExtension.class)
public class MyServiceAnnotationTest {

    // Automatically creates the mock object
    @Mock
    private ExternalApi mockApi;

    // Automatically creates MyService and injects the mockApi into its constructor
    @InjectMocks
    private MyService service;

    @Test
    public void testExternalApi() {
        // Arrange: We only need to define the stubbing here; the setup is done!
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act
        String result = service.fetchData();
        
        // Assert
        assertEquals("Mock Data", result);
    }
}