package com.frankr.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frankr.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}