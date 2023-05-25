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
        String name = "Sebastian"; 
        model.addAttribute("name", name);
        return "index";
    }
    
    // Method to get the songs and movies
    private List<Movie> getBestMovies() {
        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Movie movie = new Movie("movie " + (i + 1), i + 1);
            movieList.add(movie);
        }
        return movieList;
    }
    
    private List<Song> getBestSongs() {
        List<Song> songList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Song song = new Song("song " + (i + 1), i + 1);
            songList.add(song);
        }
        return songList;
    }
    
    // movies
    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }
    
    // songs
    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }
    
    @GetMapping("/songs/{id}")
    public String getSingleSong(Model model, @PathVariable("id") long id) {
        List<Song> songs = getBestSongs();
        Song song = null;
        for (Song s : songs) {
            if (s.getId() == id) {
                song = s;
                break;
            }
        }
        model.addAttribute("song", song);
        return "singlesong";
    }
    
    @GetMapping("/movies/{id}")
    public String getSingleMovie(Model model, @PathVariable("id") long id) {
        List<Movie> movies = getBestMovies();
        Movie movie = null;
        for (Movie m : movies) {
            if (m.getId() == id) {
                movie = m;
                break;
            }
        }
        model.addAttribute("movie", movie);
        return "singlemovie";
    }
}