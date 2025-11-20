package com.newrise.applicanttrackingsystem.DTo;

import java.util.List;

import lombok.Data;

@Data
public class PaginationResponseDTO<T> {

	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;

}
