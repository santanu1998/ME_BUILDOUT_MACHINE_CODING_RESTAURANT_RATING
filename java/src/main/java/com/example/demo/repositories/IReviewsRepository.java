package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Reviews;

public interface IReviewsRepository {
    Reviews save(Reviews reviews);
    boolean existsById(Long id);
    Optional<Reviews> findById(Long id);
    List<Reviews> findAll();
    void deleteById(Long id);
    long count();
    void delete(Reviews reviews);
}
