package com.playlist.details.repository;

import com.playlist.details.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface DetailsRepository extends JpaRepository<Details, Long> {
}
