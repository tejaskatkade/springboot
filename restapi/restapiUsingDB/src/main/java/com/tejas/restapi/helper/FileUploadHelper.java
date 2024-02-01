package com.tejas.restapi.helper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

//import java.io.FileOutputStream;
//import java.io.InputStream;

@Controller
public class FileUploadHelper {
    // Path where we want to store data
    // public final String UPLOAD_DIR = "D:\\Code\\springboot\\restapi\\restapiUsingDB\\src\\main\\resources\\static\\image";
    
    
    public final String UPLOAD_DIR = new ClassPathResource("\\static\\image").getFile().getAbsolutePath(); 
    
   FileUploadHelper() throws Exception{

    }

    public boolean uploadFile(MultipartFile multipartfFile){
    
        boolean val = false;
        
    //     // way- 1
        
    //     // reading data
    //    try {
    //     InputStream is = multipartfFile.getInputStream();
    //     byte data[] = new byte[is.available()];
    //     is.read(data);

    //     //write
    //     FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + multipartfFile.getOriginalFilename());
    //     fos.write(data);
    //     fos.flush();
    //     fos.close();
    //     val = true;

    //    } catch (Exception e) {
    //         e.printStackTrace();
    //    }

       //way-2
       try {

        Files.copy(multipartfFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartfFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
        val = true;
       } catch (Exception e) {
        e.printStackTrace();
       }
        return val;
    }
}
