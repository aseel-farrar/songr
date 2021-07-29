package com.example.songr.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.thymeleaf.spring5.expression.Mvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SongrController.class)



class SongrControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    SongrController songrController = new SongrController();

    @Test
    void helloWorld() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    void helloWorldName() throws Exception {
        SongrController songrController = new SongrController();
        RequestBuilder request = MockMvcRequestBuilders.get("/hello?name=aseel");
        MvcResult result = (MvcResult) mvc.perform(request);

        assertEquals("aseel",result.getResponse().getContentAsString() );

    }
}





//
//
//    @Test
//    void helloWorldName(){
//        SongrController songrController = new SongrController();
//        mockMvc.perform(get("/hello?name=Aseel"))
//                .andExpect(status().isOk());
//    }
//}
