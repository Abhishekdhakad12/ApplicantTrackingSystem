package com.newrise.applicanttrackingsystem.DTo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class PaginationRequestDTO {

	private int page = 0;
	private int size = 10;
	private String sortBy = "id";
	private String sortDir = "asc";
	private Map<String, String> filter = new HashMap<>();
}
