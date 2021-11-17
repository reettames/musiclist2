package hh.swd20.musiclist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.musiclist.web.SongController;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class) 
@SpringBootTest
public class MusiclistApplicationTests {

		@Autowired
		private SongController songController;
		
		@Test
		public void contextLoads() {
			assertThat(songController).isNotNull();
		}

	}

