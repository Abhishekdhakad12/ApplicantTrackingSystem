package com.newrise.applicanttrackingsystem.servicesimpl;


import com.newrise.applicanttrackingsystem.DTo.PaginationRequestDTO;
import com.newrise.applicanttrackingsystem.DTo.PaginationResponseDTO;
import com.newrise.applicanttrackingsystem.services.IPaginationService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationServiceImpl implements IPaginationService {

    @Override
    public <T> PaginationResponseDTO<T> getPaginatedData(JpaRepository<T, ?> repo, PaginationRequestDTO dto, Class<T> clazz) {
        Sort sort = dto.getSortDir().equalsIgnoreCase("asc") ?
                Sort.by(dto.getSortBy()).ascending() :
                Sort.by(dto.getSortBy()).descending();

        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), sort);
        Page<T> page = repo.findAll(pageable);

        PaginationResponseDTO<T> response = new PaginationResponseDTO<>();
        response.setContent(page.getContent());
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLastPage(page.isLast());

        return response;
    }


}
