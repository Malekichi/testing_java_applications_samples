package com.example.week3.part2.client;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PersonDetailsResponse(String name, String resourceId, PersonDetailsResponse.Status status) {

	@JsonCreator
	public PersonDetailsResponse(@JsonProperty("name") String name,
			@JsonProperty("resourceId") String resourceId, @JsonProperty("status") Status status) {
		this.name = name;
		this.resourceId = resourceId;
		this.status = status;
	}


	enum Status {
		STORED, MANUAL_PROCESSING
	}

}
