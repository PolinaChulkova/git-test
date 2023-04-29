package com.example.gistest.service;

import com.example.gistest.entity.Entity;
import com.example.gistest.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Transactional
public class EntityService {

    private final EntityRepository entityRepository;

    public Flux<Entity> findAllByUserId(Long userId) {
        return entityRepository.findAllByUserId(userId);
    }

    public Entity addEntity(Long userId, String entityName) {
        return entityRepository.save(new Entity(userId, entityName)).block();
    }
}
