package com.luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    Long id;
    String name;
    String full_name;
    String description;
    String url;
    String language;
  
}
