package com.example.todo.services;

import com.example.todo.models.Todo;
import com.example.todo.repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTodos() {
        List<Todo> mockTodos = Arrays.asList(
                new Todo("Todo 1", "Description 1"),
                new Todo("Todo 2", "Description 2")
        );
        when(todoRepository.findAll()).thenReturn(mockTodos);

        List<Todo> todos = todoService.getAllTodos();

        assertEquals(2, todos.size());
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    void testGetTodoById() {
        Todo mockTodo = new Todo("Sample Todo", "Sample Description");
        when(todoRepository.findById(1L)).thenReturn(Optional.of(mockTodo));

        Optional<Todo> todo = todoService.getTodoById(1L);

        assertTrue(todo.isPresent());
        assertEquals("Sample Todo", todo.get().getTitle());
        verify(todoRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateTodo() {
        Todo mockTodo = new Todo("New Todo", "New Description");
        when(todoRepository.save(mockTodo)).thenReturn(mockTodo);

        Todo createdTodo = todoService.createTodo(mockTodo);

        assertNotNull(createdTodo);
        assertEquals("New Todo", createdTodo.getTitle());
        verify(todoRepository, times(1)).save(mockTodo);
    }

    @Test
    void testUpdateTodo() {
        Todo existingTodo = new Todo("Old Todo", "Old Description");
        when(todoRepository.findById(1L)).thenReturn(Optional.of(existingTodo));

        Todo updatedTodo = new Todo("Updated Todo", "Updated Description");
        when(todoRepository.save(existingTodo)).thenReturn(existingTodo);

        Todo result = todoService.updateTodo(1L, updatedTodo);

        assertNotNull(result);
        assertEquals("Updated Todo", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
        verify(todoRepository, times(1)).findById(1L);
        verify(todoRepository, times(1)).save(existingTodo);
    }

    @Test
    void testDeleteTodoById() {
        doNothing().when(todoRepository).deleteById(1L);

        todoService.deleteTodoById(1L);

        verify(todoRepository, times(1)).deleteById(1L);
    }
}
