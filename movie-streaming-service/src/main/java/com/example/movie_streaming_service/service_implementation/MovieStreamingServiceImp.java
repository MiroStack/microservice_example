package com.example.movie_streaming_service.service_implementation;

import com.example.movie_streaming_service.service.MovieStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class MovieStreamingServiceImp implements MovieStreamingService {
    public static final String CATALOG_SERVICE = "http://movie-catalog-service";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String getMoviePath(Long movieInfoId) {
       var response = restTemplate.getForEntity(CATALOG_SERVICE+"/movie-info/find-path-by-id/{movieInfoId}", String.class, movieInfoId);
        return response.getBody();
    }
}
