package com.example.test;

import com.example.api.ExternalApi;
import com.example.service.MyService;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub method (optional but good practice)
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Call service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 4. VERIFY interaction (IMPORTANT STEP)
        verify(mockApi).getData();
    }
}