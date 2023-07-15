package com.frankr.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frankr.dslist.dto.GameDTO;
import com.frankr.dslist.dto.GameMinDTO;
import com.frankr.dslist.entities.Game;
import com.frankr.dslist.projections.GameMinProjection;
import com.frankr.dslist.repositories.GameRepository;


@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional
	public void creat(Game game) {
		gameRepository.save(game);
	}

	@Transactional
	public void edit(Long id, Game body) {
		
		String title = body.getTitle();
		Integer year = body.getYear();
		String genre = body.getGenre();
		String platforms = body.getPlatforms();
		Double score = body.getScore();
		String imgUrl = body.getImgUrl();
		String shortDescription = body.getShortDescription();
		String longDescription = body.getLongDescription();
		
		gameRepository.edit(id, title, year, genre, platforms, score, imgUrl, shortDescription, longDescription);
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> searchByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}