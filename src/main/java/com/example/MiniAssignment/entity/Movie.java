package com.example.MiniAssignment.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "MovieIMDB")
public class Movie {
    @DynamoDBHashKey
    private int imdbTitleId;
    private String title;
    private String original_title;
    private int year;
    private int date_published;
    private String genre;
    private int duration;
    private String country;
    private String language;
    private String director;
    private String writer;
    private String production_company;
    private String actors;
    private String description;
    private float avg_votes;
    private int votes;
    private int budget;
    private String usa_gross_income;
    private String worlwide_gross_income;
    private String metascore;
    private int reviews_from_users;
    private int reviews_from_critics;


    public void setOriginalTitle(String originalTitle) {
    }

    public void setDatePublished(String datePublished) {
    }

    public void setProductionCompany(String productionCompany) {
    }

    public void setUsaGrossIncome(String usaGrossIncome) {
    }

    public void setWorldwideGrossIncome(String worldwideGrossIncome) {
    }

    public void setReviewsFromUsers(int reviewsFromUsers) {
    }

    public void setReviewsFromCritics(int reviewsFromCritics) {
    }
}

