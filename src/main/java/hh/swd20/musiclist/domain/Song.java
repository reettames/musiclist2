package hh.swd20.musiclist.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull(message= "Can not be null")
	private String name;
	@NotNull(message="Can not be null")
	private String artist;
	private int year;
	private String length;
	
	@ManyToOne
	@JsonIgnoreProperties("songs")
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@ManyToMany
	@JoinTable(
		name = "plist", 
		joinColumns = @JoinColumn(name = "id"), 
		inverseJoinColumns = @JoinColumn(name = "playlistid"))
	private Set<Playlist> lists = new HashSet<Playlist>();
	
	public Song() {
		super();
	}
	public Song(String name, String artist, int year, String length, Category category) {
		super();
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.length = length;
		this.category = category;
	}


	public Song(String name, String artist, Category category) {
		super();
		this.name = name;
		this.artist = artist;
		this.category = category;
	}
	public Song(String name, String artist, int year, String length) {
		super();
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.length = length;
	}
	public void addList(Playlist plist) {
		this.lists.add(plist);
	}
	
	public Set<Playlist> getLists() {
		return lists;
	}
	public void setLists(Set<Playlist> lists) {
		this.lists = lists;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", year=" + year + ", length=" + length
				+ "]";
	}
	
	
	
	

}
