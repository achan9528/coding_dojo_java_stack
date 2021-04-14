package com.codingdojo.lookify.services;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	public Song createSong(Song s) {
		return songRepo.save(s);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public List<Song> searchArtist(String s){
		List<Song> searchResults = songRepo.findByArtistContaining(s);
		return searchResults;
	}
	
	public List<Song> topTen(){
		List<Song> topTen = songRepo.findTop10ByOrderByRatingDesc();
		return topTen;
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	public Song updateSong(Long id, String name,
			String artist, Integer rating) {
		Song s = findSong(id);
		s.setName(name);
		s.setArtist(artist);
		s.setRating(rating);
		songRepo.save(s);
		return s;
	}
}
