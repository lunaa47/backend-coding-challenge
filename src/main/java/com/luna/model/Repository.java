package com.luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    Long id;
    String name;
    String full_name;
    String html_url;
    String description;
    Boolean fork;
    String url;
    String language;
  
}
