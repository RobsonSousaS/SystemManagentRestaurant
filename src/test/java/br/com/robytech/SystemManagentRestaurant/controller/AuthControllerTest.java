package br.com.robytech.SystemManagentRestaurant.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver400CasoDadosEstiveremIncorretos() throws Exception{
        URI uri = new URI("/auth");
        String json = "{\"email\":\"slaoq@slaoq\",\"senha\":\"123456\"}";
        mockMvc
        .perform(MockMvcRequestBuilders
        .post(uri)
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers
        .status()
        .is(400));
    }

    @Test
public void deveriaRetornarTokenJWTQuandoDadosCorretos() throws Exception {
    URI uri = new URI("/auth");
    String json = "{\"email\":\"test@test\",\"senha\":\"123456\"}";
    mockMvc
        .perform(MockMvcRequestBuilders
        .post(uri)
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers
        .status()
        .isOk())
        .andExpect(MockMvcResultMatchers
        .jsonPath("$.token").exists());
}


}
