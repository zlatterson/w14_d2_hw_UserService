package com.example.userservice.controllers;

import com.example.userservice.models.File;
import com.example.userservice.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;
    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllUsers(){
        return new ResponseEntity<List<File>>(fileRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/files/{id}")
    public ResponseEntity findFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        return new ResponseEntity<>(file,HttpStatus.CREATED);
    }
}
