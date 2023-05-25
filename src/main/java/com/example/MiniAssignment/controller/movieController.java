package com.example.MiniAssignment.controller;

import com.example.MiniAssignment.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/movies")
public class movieController {
    private movieController csvDataReaderService;

    @Autowired
    public void MovieController(movieController csvDataReaderService) {
        this.csvDataReaderService = csvDataReaderService;
    }

    public movieController(movieController csvDataReaderService) {
        this.csvDataReaderService = csvDataReaderService;
    }

    @PostMapping("/retrievemovies")
    public ResponseEntity<String> importMovies() throws IOException {
        csvDataReaderService.readAndStoreCsvData();
        return ResponseEntity.ok("Data imported successfully.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {

        Movie movie = null;

        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    private void readAndStoreCsvData() {
    }
}
