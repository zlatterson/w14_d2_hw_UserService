package com.example.userservice.repositories;

import com.example.userservice.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FileRepository extends JpaRepository<File,Long> {
}
