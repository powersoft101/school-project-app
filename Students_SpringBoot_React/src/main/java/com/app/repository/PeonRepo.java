package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Peon;

@Repository
public interface PeonRepo extends JpaRepository<Peon, Long> {

}
