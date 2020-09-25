package com.luna.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.luna.model.GitHubApiModel;
import com.luna.model.Language;
import com.luna.model.Repository;

@RestController
@RequestMapping("/repository")
public class RepositoryController {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${apiUrl}")
	private String apiUrl;
	@Value("${numberOfDays}")
	private Long numberOfDays;
	@Value("${apiDateKey}")
	private String apiDateKey;

	@GetMapping(value = "/getTrendingLanguages", produces = "application/json")
	public Map<String,Language> getLanguagesUsedByRepositories() {
		Map<String,Language> languages =new HashMap<String,Language>();
		List<Repository> repositories = getRepositories();
		for(Repository repository : repositories) {
			if(repository.getLanguage() != null && !repository.getLanguage().isEmpty()) {
				if(!languages.containsKey(repository.getLanguage())) {
					languages.put(repository.getLanguage(), new Language());
				}
				Language language = languages.get(repository.getLanguage());
				if(language != null) {
					language.incrementNumberOfRepos();
					if(language.getRepositoriesUsingMe() != null) {
						language.getRepositoriesUsingMe().add(repository.getUrl());
					}
				}
			}
		}
		return languages;
	}

	private List<Repository> getRepositories() {
		List<Repository> repositories = new ArrayList<Repository>();
		String apiUrlUpdated = getApiUrlUpdated();
		try {
			GitHubApiModel gitHubApiModel = restTemplate.getForObject(apiUrlUpdated, GitHubApiModel.class);
			if (gitHubApiModel != null) {
				repositories = gitHubApiModel.getItems();
			}
		} catch (RestClientException exception) {
			System.err.println(exception.getMessage());
		}

		return repositories;
	}

	private String getApiUrlUpdated() {
		LocalDate date = LocalDate.now();
		date = date.minusDays(numberOfDays);
		String replacement = date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
		return apiUrl.replaceFirst(apiDateKey, replacement);
	}
}
