package com.example.userservice.controllers;

import com.example.userservice.models.File;
import com.example.userservice.models.Folder;
import com.example.userservice.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;
    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<List<Folder>>(folderRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/folders/{id}")
    public ResponseEntity findFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        return new ResponseEntity<>(folder,HttpStatus.CREATED);
    }
}
