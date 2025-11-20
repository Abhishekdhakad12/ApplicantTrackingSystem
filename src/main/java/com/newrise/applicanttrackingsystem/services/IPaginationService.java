package com.newrise.applicanttrackingsystem.services;


import org.springframework.data.jpa.repository.JpaRepository;

import com.newrise.applicanttrackingsystem.DTo.PaginationRequestDTO;
import com.newrise.applicanttrackingsystem.DTo.PaginationResponseDTO;

public interface IPaginationService {
    <T> PaginationResponseDTO<T> getPaginatedData(JpaRepository<T, ?> repo, PaginationRequestDTO dto, Class<T> clazz);
}
