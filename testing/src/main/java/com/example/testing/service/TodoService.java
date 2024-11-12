package com.example.testing.service;

import com.example.testing.domain.Todo;
import com.example.testing.dto.TodoDto;
import com.example.testing.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    final TodoRepository repository;

    public TodoDto create(TodoDto dto) {
        Todo todo = dto.toEntity();
        Todo savedTodo = repository.save(todo);
        return TodoDto.of(savedTodo);
    }

    public TodoDto get(Long id) {
        return repository.findById(id).map(TodoDto::of)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<TodoDto> getList() {
        return repository.findAll().stream()
                .map(TodoDto::of)
                .toList();
    }
}