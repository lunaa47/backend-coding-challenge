# backend-coding-challenge
Challenge for Gemography

## Specs
Develop a REST microservice that list the languages used by the 100 trending public repos on GitHub.
For every language, you need to calculate the attributes below 👇:
* Number of repos using this language
* The list of repos using the language

## Solution

Used Spring Boot for the challenge : 
3 Models : -Repository
           -Language
           -GithubApi
1 controller with the main function : getLanguagesUsedByRepositories

Jackson for a pretty output

## JSON Results
In DESC order from most used languages
```json
"Objective-C" : {
    "numberOfrepositoriesUsingMe" : 1,
    "repositoriesUsingMe" : [ "url" ]
  },
```
