// Verify exact number of calls
verify(mockApi, times(1)).getData();
verify(mockApi, times(3)).getData();

// Verify it was never called
verify(mockApi, never()).getData();

// Verify minimum or maximum calls
verify(mockApi, atLeastOnce()).getData();
verify(mockApi, atMost(2)).getData();