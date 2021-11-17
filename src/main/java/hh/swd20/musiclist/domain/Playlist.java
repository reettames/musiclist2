package hh.swd20.musiclist.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Playlist {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long playlistid;
		@NotNull(message= "Name can not be null")
		private String name;
		
		@ManyToMany(mappedBy = "lists",  cascade = { CascadeType.ALL })
		private Set<Song> songList = new HashSet<Song>();
		
		public Playlist() {
			super();
		}
		
		public Playlist(String name) {
			super();
			this.name = name;
		}
		public void addSong(Song song) {
			this.songList.add(song);
		}

		public Playlist(Long playlistid, String name) {
			super();
			this.playlistid = playlistid;
			this.name = name;
		}
		
		public Set<Song> getPlaylist() {
			return songList;
		}
		public void setPlaylist(Set<Song> playlist) {
			this.songList = playlist;
		}
		public Long getPlaylistid() {
			return playlistid;
		}
		public void setPlaylistid(Long playlistid) {
			this.playlistid = playlistid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}


