package com.example.MiniAssignment.service;

import com.example.MiniAssignment.Repository.MovieRepository;
import com.example.MiniAssignment.entity.Movie;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class service {

    private static final String CSV_FILE_PATH = "C:/Users/rahulsharma685/Downloads";

    private MovieRepository movieRepository;

    @Autowired
    public void service(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public service(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void readAndStoreCsvData() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                Movie movie = new Movie();
                movie.setTitle(csvRecord.get("title"));
                movie.setImdbTitleId(Integer.parseInt(csvRecord.get("imdbTitleId")));
                movie.setOriginalTitle(csvRecord.get("originalTitle"));
                movie.setYear(Integer.parseInt(csvRecord.get("year")));
                movie.setDatePublished(csvRecord.get("datePublished"));
                movie.setGenre(csvRecord.get("genre"));
                movie.setDuration(Integer.parseInt(csvRecord.get("duration")));
                movie.setCountry(csvRecord.get("country"));
                movie.setLanguage(csvRecord.get("language"));
                movie.setDirector(csvRecord.get("director"));
                movie.setWriter(csvRecord.get("writer"));
                movie.setProductionCompany(csvRecord.get("productionCompany"));
                movie.setActors(csvRecord.get("actors"));
                movie.setDescription(String.valueOf(Double.parseDouble(csvRecord.get("description"))));
                movie.setVotes(Integer.parseInt(csvRecord.get("votes")));
                movie.setBudget(Integer.parseInt(csvRecord.get("budget")));
                movie.setUsaGrossIncome(csvRecord.get("usaGrossIncome"));
                movie.setWorldwideGrossIncome(csvRecord.get("worldwideGrossIncome"));
                movie.setMetascore(csvRecord.get("metascore"));
                movie.setReviewsFromUsers(Integer.parseInt(csvRecord.get("reviewsFromUsers")));
                movie.setReviewsFromCritics(Integer.parseInt(csvRecord.get("reviewsFromCritics")));

                movieRepository.save(movie);
            }

        }
    }
}