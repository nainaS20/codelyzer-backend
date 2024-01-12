package com.accolite.codelyzer.repository;

import com.accolite.codelyzer.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Long> {
    List<Tag> findByTagNameIn(List<String> tagNames);
}
