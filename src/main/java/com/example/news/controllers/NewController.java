package com.example.news.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.news.database.NewDatabase;
import com.example.views.models.objects.NewDetail;
import com.example.views.models.reponses.NewModel;

@RestController
@RequestMapping("/news")
public class NewController {
	private NewDatabase newDatabase = new NewDatabase();

	@Autowired
	private ResourceLoader resourceLoader;

	@PostMapping(value = "/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty file!");
			}
			
			byte[] bytes = file.getBytes();
			String tempFolderPath = System.getProperty("java.io.tmpdir");
			Path tempFilePath = Paths.get(tempFolderPath, file.getOriginalFilename());
			Files.write(tempFilePath, bytes);

			// Tạo đường dẫn cho file upload
			Resource resource = resourceLoader.getResource("classpath:static/images/");
			String uploadPath = resource.getFile().getAbsolutePath();
			
            File sourceFile = new File(tempFilePath.toFile().getAbsolutePath());
            File destinationFile = new File(uploadPath + "\\" + sourceFile.getName());
            File systemFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\" + sourceFile.getName());            
            
            // Kiểm tra xem tệp tin đích đã tồn tại hay chưa
            if (destinationFile.exists() && systemFile.exists()) {
                // Xóa tệp tin đích
                FileUtils.forceDelete(destinationFile);
                FileUtils.forceDelete(systemFile);
            }
            FileUtils.copyFile(sourceFile, destinationFile);
            FileUtils.copyFile(sourceFile, systemFile);
            
            
            
			return ResponseEntity.ok("File uploaded successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");
		}
	}

	@GetMapping("/slugNews={slug}")
	public NewDetail getOneNew(@PathVariable String slug) {
		return newDatabase.getOneNew(slug);
	}

	@GetMapping("/category={categorySlug}/property={propertySlug}")
	public NewModel getNewByCategoryProperty(@PathVariable String categorySlug, @PathVariable String propertySlug) {
		return newDatabase.getNewByCategoryProperty(categorySlug, propertySlug);
	}

	@GetMapping("/new")
	public NewModel getNew() {
		NewModel news = newDatabase.getNew();
		return news;
	}

	@GetMapping("/category={categorySlug}")
	public NewModel getNewByCategory(@PathVariable String categorySlug) {
		return newDatabase.getNewByCategory(categorySlug);
	}
}
