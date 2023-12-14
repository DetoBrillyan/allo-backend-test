import com.allobank.allobackendtest.controller.CalegControllerTest;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.service.CalegServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalegController.class)
public class CalegControllerTest {

    
    private MockMvc mockMvc;

    @Mock
    private CalegServiceTest calegService; // Menggunakan CalegService yang sebenarnya

    @InjectMocks
    private CalegController calegController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(calegController).build();
    }

    @Test
    public void getCalegByFilter_ReturnsCalegList_WhenBothParametersGiven() throws Exception {
        // Given
        UUID dapilId = UUID.randomUUID();
        UUID partaiId = UUID.randomUUID();
        List<Caleg> expectedCalegList = Collections.singletonList(new Caleg());

        when(calegServiceTest.getCalegByDapilAndPartai(dapilId, partaiId)).thenReturn(expectedCalegList);

        // When-Then
        mockMvc.perform(get("/api/caleg/filter")
                .param("dapilId", dapilId.toString())
                .param("partaiId", partaiId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists());
        // Add more assertions if needed
    }

    @Test
    public void getCalegByFilter_ReturnsAllCaleg_WhenNoParametersGiven() throws Exception {
        // Given
        List<Caleg> expectedCalegList = Collections.singletonList(new Caleg());

        when(calegService.getAllCaleg()).thenReturn(expectedCalegList);

        // When-Then
        mockMvc.perform(get("/api/caleg/filter"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists());
        // Add more assertions if needed
    }
}