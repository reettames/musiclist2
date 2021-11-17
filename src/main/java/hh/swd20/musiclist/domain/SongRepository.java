package hh.swd20.musiclist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	 List<Song> findByName(String name);
}
