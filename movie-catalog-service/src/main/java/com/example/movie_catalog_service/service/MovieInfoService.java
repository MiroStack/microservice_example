package com.example.movie_catalog_service.service;

import com.example.movie_catalog_service.entities.MoveInfoEntity;
import com.example.movie_catalog_service.model.ApiResponseModel;

import java.util.List;

public interface MovieInfoService {
    ApiResponseModel saveAllMovieInfo(List<MoveInfoEntity> movieInfoList);
    ApiResponseModel getALLMovieInfo();
}
