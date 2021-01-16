package com.dogapi.test.web;

import com.dogapi.test.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // defines Spring Runner class to run test cases
@WebMvcTest(DogController.class) // use WebMvc test for unit testing and define the Controller class being used
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc; // use MockMvc to quickly test MVC Controllers without Http server

    // @MockBean annotation mocks the Service layer bean
    // @MockBean creates Mockito mock of the services which are dependencies of the Controller
    @MockBean
    DogService dogService;

    @Test
//    @WithMockUser
    public void getAllDogs() throws Exception {
        this.mockMvc.perform(get("/dogs") // mockMvc.perform() simulates HTTP request to REST controller
                .with(user("admin").password("password").roles("USER","ADMIN"))) // 1 approach to test with basic auth
                .andExpect(status().isOk()) // set Expectations on HTTP responses status received from Controller class
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]")); // expecting JSON responded back

        // verifies the times (1 time) a mock method has been called
        verify(this.dogService, times(1)).retrieveAllDogs();
    }

    @Test
    @WithMockUser
    public void getADog() throws Exception {
        this.mockMvc.perform(get("/dogs/1/breed"))
                .andExpect(status().isOk()); // set Expectations on HTTP responses status received from Controller class

        // verifies the times (1 time) a mock method has been called
        verify(this.dogService, times(1)).retrieveDogBreedById(1L);
    }
}
