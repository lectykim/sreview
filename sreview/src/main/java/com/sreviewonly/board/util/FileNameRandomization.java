package com.sreviewonly.board.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileNameRandomization {

    public static String uploadFileWithUUID(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();

        String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + extension;

        String fullPath = "C:\\new_project\\sreview\\sreview\\src\\main\\resources\\static\\image\\" + newFileName;

        try{
            byte[] bytes = multipartFile.getBytes();
            Files.write(Paths.get(fullPath),bytes);
        } catch (IOException e) {
            System.out.println("-------------File Upload Exception!--------------");
            System.out.println(e);
        }

        return newFileName;

    }

}
