package com.example.springreactgradle;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProducts() throws Exception {
        this.mockMvc.perform(get("/api/product")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getProduct() throws Exception {
        this.mockMvc.perform(get("/api/product/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void postProduct() throws Exception {
        String jsonString = "{ \"name\":\"Смартфон HONOR\", \"price\":20000, \"description\":\"Смартфон\"}";

        this.mockMvc.perform(post("/api/product").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andDo(print()).andExpect(status().isOk());
    }
}
