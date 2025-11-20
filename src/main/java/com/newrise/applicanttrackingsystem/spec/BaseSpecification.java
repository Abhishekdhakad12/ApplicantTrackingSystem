package com.newrise.applicanttrackingsystem.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class BaseSpecification<T> implements Specification<T> {

    private final Map<String, String> filters;

    public BaseSpecification(Map<String, String> filters) {
        this.filters = filters;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        filters.forEach((key, value) -> {
            if (value != null && !value.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get(key)), "%" + value.toLowerCase() + "%"));
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}

