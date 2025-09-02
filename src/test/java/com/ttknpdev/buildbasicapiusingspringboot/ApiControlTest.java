package com.ttknpdev.buildbasicapiusingspringboot;

import com.ttknpdev.buildbasicapiusingspringboot.controller.ApiControl;
import com.ttknpdev.buildbasicapiusingspringboot.entity.Romance;
import com.ttknpdev.buildbasicapiusingspringboot.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ApiControl.class)
public class ApiControlTest {

    // *** using MockMvc class to make REST API calls.
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService<Romance> booksService;

    @Test
    public void testRomanceReadsApi() throws Exception {
        // ** provider
        given(booksService.reads()).willReturn(getRomances());

        // ** call the provider ** and set basic authenticate on http header
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/romance/reads");

        // ** ResultActions class to handle the response of the REST API.
        ResultActions response = mockMvc.perform(request);

        // then - verify the output
        response
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(header().string("Content-Type", "application/json"));
    }

    private Iterable<Romance> getRomances() {
        return List.of(new Romance(), new Romance(), new Romance());
    }


}
