import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

// 1. The External Dependency
interface ExternalApi {
    String getData();
    void sendData(String data);
}

// 2. The Service Being Tested
class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void fetchData() {
        // The service calls the API, but we might not return the data directly.
        // We just need to know this call happened.
        externalApi.getData();
    }
    
    public void processAndSend(String input) {
        externalApi.sendData(input);
    }
}

// 3. The Test Class
public class MyServiceTest { 
    
    @Test 
    public void testVerifyInteraction() { 
        // 1. ARRANGE: Create the mock object
        ExternalApi mockApi = mock(ExternalApi.class); 
        MyService service = new MyService(mockApi); 
        
        // 2. ACT: Call the method 
        service.fetchData(); 
        
        // 3. ASSERT (Verify): Check that the interaction occurred
        verify(mockApi).getData(); 
    } 
}