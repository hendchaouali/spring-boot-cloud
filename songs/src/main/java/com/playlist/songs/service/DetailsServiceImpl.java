package com.playlist.songs.service;

import com.playlist.songs.client.DetailsClient;
import com.playlist.songs.client.DetailsFeignClient;
import com.playlist.songs.model.Details;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DetailsServiceImpl {

    private final DetailsClient detailsClient;
    private final DetailsFeignClient detailsFeignClient;

    public DetailsServiceImpl(DetailsClient detailsClient, DetailsFeignClient detailsFeignClient) {
        this.detailsClient = detailsClient;
        this.detailsFeignClient = detailsFeignClient;
    }

    public Details getDetailUsingRestTemplate(Long id) {
        return detailsClient.getDetailBySongId(id);
    }

    public Details getDetailsUsingFeignClient(Long id) {
        return detailsFeignClient.getDetailBySongId(id);
    }
}
