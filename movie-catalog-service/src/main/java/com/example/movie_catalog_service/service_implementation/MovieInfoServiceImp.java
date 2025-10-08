package com.example.movie_catalog_service.service_implementation;

import com.example.movie_catalog_service.entities.MoveInfoEntity;
import com.example.movie_catalog_service.model.ApiResponseModel;
import com.example.movie_catalog_service.repository.MovieInfoRepository;
import com.example.movie_catalog_service.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieInfoServiceImp implements MovieInfoService {
    @Autowired
    private MovieInfoRepository repo;
    @Override
    public ApiResponseModel saveAllMovieInfo(List<MoveInfoEntity> movieInfoList) {
        ApiResponseModel res = new ApiResponseModel();
        try{
            List<MoveInfoEntity> list =  repo.saveAll(movieInfoList);
            res.setStatusCode(200);
            res.setMessage("SUCCESS");
            res.setData(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public ApiResponseModel getALLMovieInfo() {
        ApiResponseModel res = new ApiResponseModel();
        try{
            List<MoveInfoEntity> list =  repo.findAll();
            res.setStatusCode(200);
            res.setMessage("SUCCESS");
            res.setData(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String getPathById(Long id) {
        Optional<MoveInfoEntity> videoInfoOptional = repo.findById(id);

        return videoInfoOptional.map(MoveInfoEntity::getPath).orElse(null);
    }


}
