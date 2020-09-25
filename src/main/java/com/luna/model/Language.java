package com.luna.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Language {
	@Setter(AccessLevel.NONE)
	Long numberOfrepositoriesUsingMe = 0L;
	@Setter(AccessLevel.NONE)
	List<String> repositoriesUsingMe = new ArrayList<>();
	public void incrementNumberOfRepos() {
		this.numberOfrepositoriesUsingMe++;
	}
	
	
}
