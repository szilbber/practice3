package com.example.restaurant;


import com.example.restaurant.controller.VisitorController;
import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.service.VisitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(VisitorController.class)
public class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VisitorService visitorService;

    @Test
    public void testGetAllUsers() throws Exception {

        when(visitorService.findAll()).thenReturn(List.of(
                new VisitorResponseDTO(1L, "Иван", 30, "мужской"),
                new VisitorResponseDTO(2L, "Мария", 25, "женский")
        ));

        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Иван")))
                .andExpect(jsonPath("$[1].name", is("Мария")))
                .andDo(print());
    }

    @Test
    public void testGetUserById() throws Exception {
        when(visitorService.findById(1L)).thenReturn(new VisitorResponseDTO(1L, "Иван", 30, "мужской"));

        mockMvc.perform(get("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Иван")))
                .andExpect(jsonPath("$.age", is(30)))
                .andExpect(jsonPath("$.gender", is("мужской")));
    }

    @Test
    public void testCreateUser() throws Exception {
        VisitorRequestDTO requestDTO = new VisitorRequestDTO("Иван", 30, "мужской");
        VisitorResponseDTO responseDTO = new VisitorResponseDTO(1L, "Иван", 30, "мужской");

        when(visitorService.save(requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Иван")));
    }

    @Test
    public void testUpdateUser() throws Exception {
        VisitorRequestDTO requestDTO = new VisitorRequestDTO("Иван", 35, "мужской");
        VisitorResponseDTO responseDTO = new VisitorResponseDTO(1L, "Иван", 35, "мужской");

        when(visitorService.update(1L, requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age", is(35)));
    }

    @Test
    public void testDeleteUser() throws Exception {
        doNothing().when(visitorService).deleteById(1L);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}