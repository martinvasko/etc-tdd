package at.etc.coinanalyzer;

import at.etc.coinanalyzer.repository.BlockchainRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AppTests {

    @Autowired
    private WebApplicationContext applicationContext;

    @MockBean
    BlockchainRepository repository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Mock Context
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();

        // Mock repository
        JSONArray ja = new JSONArray();

        JSONObject jo = new JSONObject();
        jo.put("name", "Bitcoin");
        jo.put("symbol", "BTC");
        jo.put("price", 123);
        jo.put("percentage", 10);

        ja.put(jo);

        when(repository.getAllStatistics()).thenReturn(ja);
    }

    @Test
    public void testApiShouldReturnSameClassAsJSONArray() throws Exception {
        this.mockMvc.perform(
                        get("/statistics"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testCoinShouldBouldCorrect() {

    }


    @Test
    public void testStream() {

    }


}

