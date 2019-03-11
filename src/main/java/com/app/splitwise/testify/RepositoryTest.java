package com.app.splitwise.testify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTest extends JpaRepository<Person, Integer> {
}
