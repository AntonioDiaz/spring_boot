package com.controller;

import com.model.Song;
import com.services.SongDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongResource {

	@Autowired
	private SongDAOService songDAOService;
	
	@GetMapping ("/songs")
	public List<Song> retrieveAllSong() {
		return songDAOService.findAll();
	}
	
	@GetMapping ("/songs/{id}")
	public Song retrieveSong(@PathVariable int id) {
		return songDAOService.findOne(id);
	}

	@PostMapping("songs")
	public Song createSong(@RequestBody Song song) {
		return songDAOService.save(song);
	}
}
