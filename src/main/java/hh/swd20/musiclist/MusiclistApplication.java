package hh.swd20.musiclist;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.musiclist.domain.Category;
import hh.swd20.musiclist.domain.CategoryRepository;
import hh.swd20.musiclist.domain.Playlist;
import hh.swd20.musiclist.domain.PlaylistRepository;
import hh.swd20.musiclist.domain.Song;
import hh.swd20.musiclist.domain.SongRepository;
import hh.swd20.musiclist.domain.User;
import hh.swd20.musiclist.domain.UserRepository;

@SpringBootApplication
public class MusiclistApplication {
	private static final Logger log = LoggerFactory.getLogger(MusiclistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusiclistApplication.class, args);
	}

	@Bean
	public CommandLineRunner SongDemo(SongRepository songRepo, UserRepository userRepo, CategoryRepository catRepo, PlaylistRepository plistRepo) {
		return (args) -> {
			Category cat1 = new Category("Pop");
			Category cat2 = new Category("Rap");
			catRepo.save(cat1);
			catRepo.save(cat2);
			
			log.info("save a couple of songs");
			Song song1 = new Song("Ghost", "Justin Bieber", 2021, "2:33", cat1);
			songRepo.save(song1);
			Song song2 = new Song("Money", "LISA", 2021, "2:48", cat2);
			songRepo.save(song2);
			Song song3 = new Song("Easy on me", "Adele", 2021, "3:45", cat1);
			songRepo.save(song3);
			Song song4 = new Song("Kiss me more", "Doja Cat", 2021, "3:18", cat2);
			songRepo.save(song4);
			
			Playlist plist1 = new Playlist("Kesäbiisit");
			Playlist plist2 = new Playlist("2020");
		
			plistRepo.save(plist1);
			plistRepo.save(plist2);
			
			plist1.addSong(song1);
			plist1.addSong(song2);
			song1.addList(plist1);
			song2.addList(plist1);
			
			plist2.addSong(song3);
			song3.addList(plist2);
			
			plistRepo.save(plist1);
			plistRepo.save(plist2);
			
			
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(admin);
			
		};
}
}
