package com.example.todo.controllers;

import com.example.todo.models.Todo;
import com.example.todo.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TodoControllerTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoService todoService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    }

    @Test
    void testGetAllTodos() throws Exception {
        when(todoService.getAllTodos()).thenReturn(Arrays.asList(
                new Todo("Todo 1", "Description 1"),
                new Todo("Todo 2", "Description 2")
        ));

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetTodoById() throws Exception {
        Todo mockTodo = new Todo("Sample Todo", "Sample Description");
        when(todoService.getTodoById(1L)).thenReturn(Optional.of(mockTodo));

        mockMvc.perform(get("/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Sample Todo"));
    }

    @Test
    void testCreateTodo() throws Exception {
        Todo mockTodo = new Todo("New Todo", "New Description");
        when(todoService.createTodo(any(Todo.class))).thenReturn(mockTodo);

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"New Todo\", \"description\":\"New Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Todo"));
    }

    @Test
    void testUpdateTodo() throws Exception {
        Todo mockTodo = new Todo("Updated Todo", "Updated Description");
        when(todoService.updateTodo(eq(1L), any(Todo.class))).thenReturn(mockTodo);

        mockMvc.perform(put("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Updated Todo\", \"description\":\"Updated Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Todo"));
    }

    @Test
    void testDeleteTodoById() throws Exception {
        doNothing().when(todoService).deleteTodoById(1L);

        mockMvc.perform(delete("/todos/1"))
                .andExpect(status().isNoContent());
    }
}
