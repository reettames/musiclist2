package hh.swd20.musiclist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.musiclist.domain.CategoryRepository;
import hh.swd20.musiclist.domain.PlaylistRepository;
import hh.swd20.musiclist.domain.Song;
import hh.swd20.musiclist.domain.SongRepository;

@CrossOrigin
@Controller
public class SongController {
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private PlaylistRepository plistRepo;
	
	@RequestMapping(value= "/hello")
	public String welcome(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("playlists", plistRepo.findAll());
		return "welcome";
		
	}
    @RequestMapping(value = "/addsong")
    public String addSong(Model model){
		model.addAttribute("categories", catRepo.findAll());
    	model.addAttribute("song", new Song());
        return "addsong"; 
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Song song) {
        songRepository.save(song);
        return "redirect:hello";
    }
    
    @RequestMapping(value="/songs", method = RequestMethod.GET)
    public @ResponseBody List<Song> songListRest() {	
        return (List<Song>) songRepository.findAll();
    }    

	// REST
    @RequestMapping(value="/songs/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {	
    	return songRepository.findById(songId);
    }  
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSong(@PathVariable("id") Long songId, Model model) {
    	songRepository.deleteById(songId);
        return "redirect:../hello";
    }  
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSong(@PathVariable("id") Long songId, Model model) {
    	model.addAttribute("categories", catRepo.findAll());
    	model.addAttribute("song", songRepository.findById(songId).get());
        return "editsong";
    } 
}
