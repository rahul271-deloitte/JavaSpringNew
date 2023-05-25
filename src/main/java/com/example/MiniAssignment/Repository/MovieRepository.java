package com.example.MiniAssignment.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.MiniAssignment.entity.Movie;


@Repository
public class MovieRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public <Movie> Movie save(Movie movie) {
        dynamoDBMapper.save(movie);
        return movie;
    }

    public Movie getMovieById(String imdbTitleId) {
        return dynamoDBMapper.load(Movie.class, imdbTitleId);
    }

    public String delete(String imdbTitleId) {
        Movie movie = dynamoDBMapper.load(Movie.class, imdbTitleId);
        dynamoDBMapper.delete(movie);
        return "Movie Deleted!";
    }

    public String update(String imdbTitleId, Movie movie) {
        dynamoDBMapper.save(movie,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("imdb_title_id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(imdbTitleId)
                                )));
        return imdbTitleId;
    }
}
