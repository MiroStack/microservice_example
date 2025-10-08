package com.example.movie_catalog_service.controllers;

import com.example.movie_catalog_service.entities.MoveInfoEntity;
import com.example.movie_catalog_service.model.ApiResponseModel;
import com.example.movie_catalog_service.service_implementation.MovieInfoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MoveInfoController {
     @Autowired
    MovieInfoServiceImp serviceImp;
    @PostMapping("/movie-info/save")
    public ResponseEntity<ApiResponseModel> saveAllMovieInfo(@RequestBody List<MoveInfoEntity> movieInfoList){
        try{
            return ResponseEntity.ok(serviceImp.saveAllMovieInfo(movieInfoList));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/movie-info/list")
    public ResponseEntity<ApiResponseModel> getAllMovieInfo(){
        try{
            return ResponseEntity.ok(serviceImp.getALLMovieInfo());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String getPathById(@PathVariable Long movieInfoId){
        return serviceImp.getPathById(movieInfoId);
    }
}
