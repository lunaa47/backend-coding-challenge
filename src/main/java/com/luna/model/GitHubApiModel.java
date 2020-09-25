package com.luna.model;

import java.util.List;

import lombok.Data;

@Data
public class GitHubApiModel {
	Long total_count;
	Boolean incomplete_results;
	List<Repository> items;
}
