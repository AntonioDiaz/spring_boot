package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.model.Song;

@Service
public class SongDAOService {

	private static int maxId = 3;
	private static List<Song> songs = new ArrayList<>();
	
	static {
		songs.add(new Song(1, "Boy", "U2"));
		songs.add(new Song(2, "Achtung Baby", "U2"));
		songs.add(new Song(3, "The Joshua tree", "U2"));
	}

	public List<Song> findAll(){
		return songs;
	}
	
	public Song findOne(int id) {
		Stream<Song> filter = songs.stream().filter(e -> e.getId()==id);
		if (filter.count()>0) {
			Song mySong = filter.findFirst().get();
			return mySong;
		}
		return null;
	}
	
	public Song save(Song song) {
		if (song.getId()==null) {
			song.setId(++maxId);
		}
		songs.add(song);
		return song;
	}
}
