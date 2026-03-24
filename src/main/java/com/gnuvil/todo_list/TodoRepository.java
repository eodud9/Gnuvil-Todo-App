package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public void save(Todo todo) {
        em.persist(todo);

    }

    public Todo findById(Long id) {
        Todo todo = em.find(Todo.class, id);
        return todo;
    }

}
