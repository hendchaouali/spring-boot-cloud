package com.playlist.details.service;

import com.playlist.details.model.Details;
import com.playlist.details.repository.DetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DetailsServiceImpl implements IDetailsService {
    private static final Logger log = LoggerFactory.getLogger(DetailsServiceImpl.class);

    private final DetailsRepository detailsRepository;

    public DetailsServiceImpl(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @Override
    public Details createDetails(Details details) {
        return detailsRepository.save(details);
    }

    @Override
    public Details getDetailById(Long id) {
        return detailsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Not found details with id = " + id));
    }
}
