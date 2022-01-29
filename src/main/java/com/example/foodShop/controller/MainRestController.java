package com.example.foodShop.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/foodRest")
public class MainRestController {
    @GetMapping(
            value = "/image/{userPicture}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImageForEveryone(
            @PathVariable("userPicture") String userPicture
    ) {
        try{
            System.out.println(userPicture);
            File file = new File("C:\\Users\\Rustam\\Desktop\\" +
                    "Developia\\FINAL PROJECTS\\BACKEND PROJECT\\" +
                    "easy project\\foodShop\\foodShop\\src\\main\\" +
                    "resources\\static\\baseImages\\" + userPicture);

                    InputStream in = new FileInputStream(file);
            return IOUtils.toByteArray(in);
        } catch (FileNotFoundException fex){
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
