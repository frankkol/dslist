package com.frankr.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frankr.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}