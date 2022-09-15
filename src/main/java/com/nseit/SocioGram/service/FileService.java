package com.nseit.SocioGram.service;


import com.nseit.SocioGram.model.File;
import com.nseit.SocioGram.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File uploadFile(File file){
        return fileRepository.save(file);
    }

}
