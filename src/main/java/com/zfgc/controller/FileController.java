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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.filesys.ZfgcInvalidFileException;
import com.zfgc.model.avatar.AvatarStaging;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.services.avatar.AvatarService;
import com.zfgc.services.content.ContentService;

@Controller
@RequestMapping("/contentstream")
public class FileController extends BaseController{
	
	@Autowired
	ContentService contentService;
	
	@Autowired
	AvatarService avatarService;
	
	@RequestMapping(value="/avatar/{avatarId}", method=RequestMethod.GET)
	public ResponseEntity getAvatar(@PathVariable("avatarId") Integer avatarId, HttpServletResponse response){
		InputStreamWrapper is = null;

		is = contentService.getAvatarHandle(avatarId);

		return ResponseEntity.status(HttpStatus.OK)
				             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=avatar" + avatarId)
				             .contentType(MediaType.IMAGE_JPEG)
				             .body(new InputStreamResource(is.getIs()));
	}
	
	@RequestMapping(value="/avatar/gallery/{galleryId}", method=RequestMethod.GET)
	public ResponseEntity getGalleryAvatar(@PathVariable("galleryId") Integer galleryId, HttpServletResponse response){
		InputStreamWrapper is = null;

		is = contentService.getAvatarGalleryHandle(galleryId);

		return ResponseEntity.status(HttpStatus.OK)
				             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + galleryId)
				             .contentType(MediaType.IMAGE_JPEG)
				             .body(new InputStreamResource(is.getIs()));
	}
	
	@RequestMapping(value="/avatar/{usersId}", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('ZFGC_USER')")
	public ResponseEntity uploadAvatar(@PathVariable("usersId") Integer usersId, @RequestParam("avatarFile") MultipartFile file){
		AvatarStaging staged = avatarService.stageAvatar(file, zfgcUser());

		return ResponseEntity.ok(staged);
	}
	
	
}