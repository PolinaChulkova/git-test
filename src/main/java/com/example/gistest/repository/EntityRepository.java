package com.example.gistest.repository;

import com.example.gistest.entity.Entity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Repository
@Transactional
public interface EntityRepository extends ReactiveCrudRepository<Entity, Long> {

    Flux<Entity> findAllByUserId(Long userId);
}
