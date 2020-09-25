package com.luna.model;

import java.util.List;

import lombok.Data;

@Data
public class GitHubApiModel {
	List<Repository> items;
}
