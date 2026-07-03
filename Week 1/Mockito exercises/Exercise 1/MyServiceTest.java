import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals; // Added correct JUnit 5 import
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// 1. The External Dependency
interface ExternalApi {
    String getData();
}

// 2. The Service Being Tested (System Under Test)
class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}

// 3. The Test Class
public class MyServiceTest { 
    
    @Test 
    public void testExternalApi() { 
        // Arrange: Create the mock and stub its behavior
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        // Arrange: Inject the mock into our service
        MyService service = new MyService(mockApi); 
        
        // Act: Call the method we actually want to test
        String result = service.fetchData(); 
        
        // Assert: Verify the service handled the mocked data correctly
        assertEquals("Mock Data", result); 
    } 
}