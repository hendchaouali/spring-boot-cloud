package com.playlist.songs.client;

import com.playlist.songs.model.Details;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "details")
public interface DetailsFeignClient {

    @GetMapping("/details/{id}")
    Details getDetailBySongId(@PathVariable Long id);
}
