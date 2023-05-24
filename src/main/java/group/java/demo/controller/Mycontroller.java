package group.java.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import group.java.demo.enity.Movie;
import group.java.demo.enity.Song;



@Controller
@RequestMapping("/")
public class Mycontroller {
	
	 @GetMapping("/home")
	    public String getBestOfYear(Model model) {
	        String yourName = "Sebastian"; 

	        model.addAttribute("name", yourName);
	        return "index";
	    }
	 
	 //Method to get the songs and movies
	 private List<Movie> getBestMovies(){
			List<Movie> movieList = new ArrayList<>();
			for(int i = 0; i<3; i++) {
				Movie movie = new Movie("movie " + (i+1), i+1);
				movieList.add(movie);
			}
			return movieList;
		}
		
		private List<Song> getBestSongs(){
			List<Song> songList = new ArrayList<>();
			for(int i = 0; i<3; i++) {
				Song song = new Song("song " + (i+1), i+1);
				songList.add(song);
			}
			return songList;
		}

	//movies
		
		@GetMapping("/movies")
		public String getMovies(Model model) {
			
			String moviesList = "";
			List<Movie> movies = getBestMovies();
			
			for(int i = 0; i<movies.size(); i++) {
				
					moviesList += movies.get(i).getName() + ", ";
				
			}
			
			model.addAttribute("moviesList", moviesList);
			
			return "movies";
		}
		
		//songs
		
		@GetMapping("/songs")
		public String getSongs(Model model) {
			
			String songsList = "";
			List<Song> songs = getBestSongs();
			
			for(int i = 0; i<songs.size(); i++) {
				
					songsList += songs.get(i).getName() + ", ";
				
			}
			
			model.addAttribute("songsList", songsList);
			
			return "songs";
		}  
		
		@GetMapping("/songs/{id}")
		public String getSongDetail(Model model, @PathVariable("id") long id) {
			
			List<Song> songs = getBestSongs();
			String song = null;
			
			for(int i = 0; i<songs.size(); i++) {
				if(id == songs.get(i).getId()) {
					song = songs.get(i).getName();
					break;
				}
			}
			
			model.addAttribute("song", song);
			
			return "singlesong";
		}
}
