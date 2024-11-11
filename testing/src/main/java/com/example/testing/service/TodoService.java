package com.example.testing.service;

import com.example.testing.domain.Todo;
import com.example.testing.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(Todo todo) {

        todoRepository.save(todo);
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
    public void updateTodo(Todo todo) {
        Todo todos=Todo.builder().title("바꿔").description("막바꿔").build();
        todoRepository.save(todos);
    }
}
