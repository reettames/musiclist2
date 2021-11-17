package hh.swd20.musiclist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.musiclist.domain.Playlist;
import hh.swd20.musiclist.domain.PlaylistRepository;
import hh.swd20.musiclist.domain.Song;
import hh.swd20.musiclist.domain.SongRepository;

@Controller
public class PlaylistController {
	
	@Autowired
	private PlaylistRepository plistRepo;
	
	@Autowired
	private SongRepository songRepo;
	
    @RequestMapping(value = "/addplist")
    public String addSong(Model model){
    	model.addAttribute("playlist", new Playlist());
    	model.addAttribute("songs", songRepo.findAll());
        return "addplaylist"; 
    }
    @RequestMapping(value = "/savePlaylist", method = RequestMethod.POST)
    public String save(Playlist playlist) {
        plistRepo.save(playlist);
        return "redirect:hello";
    }
    @RequestMapping(value = "/saveSong", method = RequestMethod.POST)
    public String saveSong() {
        return "error";
    }
	
    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.GET)
    public String showPlaylist(@PathVariable("id") Long playlistId, Model model) {
    	model.addAttribute("playlist", plistRepo.findById(playlistId).get());
    	model.addAttribute("songs", songRepo.findAll());
        return "playlist";
    } 

}
