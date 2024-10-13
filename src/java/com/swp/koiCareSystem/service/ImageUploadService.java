/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.swp.koiCareSystem.config.IConstant;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.Part;

/**
 *
 * @author DELL
 */
public class ImageUploadService {
    private Cloudinary cloudinary;
    public ImageUploadService(){
         cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", IConstant.CLOUDINARY_NAME,
                    "api_key",  IConstant.CLOUDINARY_API_KEY,
                    "api_secret", IConstant.CLOUDINARY_API_SECRET
            ));
    }
    
    public String uploadImage(Part filePart, String uploadPath) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String fileName = filePart.getSubmittedFileName();
//        Dat ten cho anh
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
        File fileToUpload = new File(uploadDir + File.separator + uniqueFileName);
        filePart.write(fileToUpload.getAbsolutePath());
        // Upload file lên Cloudinary
        Map uploadResult = cloudinary.uploader().upload(fileToUpload, ObjectUtils.emptyMap());
        String imageUrl = (String) uploadResult.get("secure_url");
        if (fileToUpload.exists()) {
        fileToUpload.delete(); // Xóa file tạm
        }
        return imageUrl;
    }
}
