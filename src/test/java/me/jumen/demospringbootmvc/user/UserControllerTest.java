package me.jumen.demospringbootmvc.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
autoconfigure.jar -> spring.factories 참고
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"jumen\", \"password\":\"5215\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept((MediaType.APPLICATION_JSON))
                .content(userJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is(equalTo("jumen"))))
            .andExpect(jsonPath("$.password", is(equalTo("5215"))));

    }

    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"jumen\", \"password\":\"5215\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept((MediaType.APPLICATION_XML))
                .content(userJson))
            .andExpect(status().isOk())
            .andExpect(xpath("/User/username").string("jumen"))
            .andExpect(xpath("/User/password").string("5215"));

    }
}
