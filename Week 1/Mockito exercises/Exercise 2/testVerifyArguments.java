@Test
public void testVerifyArguments() {
    ExternalApi mockApi = mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    // Act
    service.processAndSend("Hello World");

    // Verify the exact string was passed
    verify(mockApi).sendData("Hello World");
    
    // Or, if you just care about the type, you can use Argument Matchers
    verify(mockApi).sendData(anyString());
}