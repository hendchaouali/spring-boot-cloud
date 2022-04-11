package com.playlist.details.service;

import com.playlist.details.model.Details;

public interface IDetailsService {
    Details createDetails(Details details);
    Details getDetailById(Long id);
}
