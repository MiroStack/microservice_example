package com.example.movie_catalog_service.repository;

import com.example.movie_catalog_service.entities.MoveInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MoveInfoEntity, Long> {
}
