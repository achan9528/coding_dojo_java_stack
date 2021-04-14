package com.codingdojo.lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
    
    List<Song> findAll();
    
    List<Song> findByNameContaining(String search);
    
    Long countByNameContaining(String search);
    
    Long deleteByNameStartingWith(String search);
    
    List<Song> findByArtistContaining(String search);
    
    List<Song> findTop10ByOrderByRatingDesc();
}
