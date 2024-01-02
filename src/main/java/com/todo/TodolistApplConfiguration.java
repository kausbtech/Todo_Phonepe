package com.todo;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

import io.dropwizard.db.DataSourceFactory;


public class TodolistApplConfiguration extends Configuration {
    // TODO: implement service configuration
    private String url;

    private DataSourceFactory database = new DataSourceFactory();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }
}
