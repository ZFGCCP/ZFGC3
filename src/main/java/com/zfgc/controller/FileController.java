package com.zfgc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.services.content.ContentService;

@Controller
@RequestMapping("/contentstream")
public class FileController extends BaseController{
	
	@Autowired
	ContentService contentService;
	
	@RequestMapping(value="/avatar/{avatarId}", method=RequestMethod.GET)
	public ResponseEntity getAvatar(@PathVariable("avatarId") Integer avatarId, HttpServletResponse response){
		InputStreamWrapper is = null;
		
		try{
			is = contentService.getAvatarHandle(avatarId);
		}
		catch(FileNotFoundException  e){
			e.printStackTrace();
			return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
		} catch (ZfgcNotFoundException e) {
			e.printStackTrace();
			return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.status(HttpStatus.OK)
				             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + is.getFileName().substring(is.getFileName().lastIndexOf("/")))
				             .contentType(MediaType.TEXT_PLAIN)
				             .body(new InputStreamResource(is.getIs()));
	}
	
	@RequestMapping(value="/avatar/gallery/{galleryId}", method=RequestMethod.GET)
	public ResponseEntity getGalleryAvatar(@PathVariable("galleryId") Integer galleryId, HttpServletResponse response){
		InputStreamWrapper is = null;
		
		try{
			is = contentService.getAvatarGalleryHandle(galleryId);
		}
		catch(FileNotFoundException  e){
			e.printStackTrace();
			return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
		} catch (ZfgcNotFoundException e) {
			e.printStackTrace();
			return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.OK)
				             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + galleryId)
				             .contentType(MediaType.TEXT_PLAIN)
				             .body(new InputStreamResource(is.getIs()));
	}
}