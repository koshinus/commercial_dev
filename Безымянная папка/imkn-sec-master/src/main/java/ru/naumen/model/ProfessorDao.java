package ru.naumen.model;

import java.util.Optional;

import ru.naumen.entities.Professor;

public interface ProfessorDao {

    Optional<Professor> find(int id);

    Optional<Professor> findByLogin(String login);

    void save(Professor professor);
}
