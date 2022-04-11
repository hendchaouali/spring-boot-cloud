package com.playlist.details.resource;

import com.playlist.details.model.Details;
import com.playlist.details.service.IDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/details")
public class DetailsResource {

    final private IDetailsService detailsService;

    public DetailsResource(IDetailsService detailsService) {
        this.detailsService = detailsService;
    }


    @PostMapping
    public ResponseEntity<Details> createDetails(@Valid @RequestBody Details details) {
        return new ResponseEntity<>(detailsService.createDetails(details), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Details> getDetailById(@PathVariable Long id) {
        return new ResponseEntity<>(detailsService.getDetailById(id), HttpStatus.OK);
    }

}
