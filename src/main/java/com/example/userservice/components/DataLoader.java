package com.example.userservice.components;

import com.example.userservice.models.File;
import com.example.userservice.models.Folder;
import com.example.userservice.models.User;
import com.example.userservice.repositories.FileRepository;
import com.example.userservice.repositories.FolderRepository;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;
    public DataLoader(){

    }
    public void run(ApplicationArguments args){
        User andrew = new User("Andrew");
        userRepository.save(andrew);
        User claudia = new User("Claudia");
        userRepository.save(claudia);

        Folder documents = new Folder("Documents",claudia);
        folderRepository.save(documents);

        Folder pictures = new Folder("Pictures",andrew);
        folderRepository.save(pictures);

        File dogPic = new File("Jasper_On_A_Walk",".png",100,pictures);
        fileRepository.save(dogPic);
    }
}
