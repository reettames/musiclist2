package hh.swd20.musiclist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.musiclist.domain.Song;
import hh.swd20.musiclist.domain.SongRepository;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private SongRepository songRepo;
	
	@Test
	public void findByName() {
		List <Song> songs = songRepo.findByName("Money");

		assertThat(songs).hasSize(1);
		assertThat(songs.get(0).getArtist()).isEqualTo("Lisa");
	}
 
	@Test 
	public void createNewSong() {
	 	Song song = new Song("Love again", "Dua Lipa", 2021, "4:18");
	 	songRepo.save(song);
	 	assertThat(song.getId()).isNotNull();
 }    

}
