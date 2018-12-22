package com.zfgc.services.content;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.zfgc.dataprovider.AvatarDataProvider;
import com.zfgc.dataprovider.ContentDataProvider;
import com.zfgc.dataprovider.FileUploadTempDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.filesys.ZfgcInvalidFileException;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Component
public class ContentService extends AbstractService{
	@Autowired
	ContentDataProvider contentDataProvider;
	
	@Autowired
	AvatarDataProvider avatarDataProvider;
	
	@Autowired
	FileUploadTempDataProvider fileUploadTempDataProvider;
	
	public InputStreamWrapper getAvatarHandle(Integer avatarId) throws FileNotFoundException, ZfgcNotFoundException{
		try {
			return contentDataProvider.getAvatarHandle(avatarId);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (ZfgcNotFoundException e) {
			throw new ZfgcNotFoundException("Avatar " + avatarId);
		}
	}
	
	public InputStreamWrapper getAvatarGalleryHandle(Integer galleryId) throws FileNotFoundException, ZfgcNotFoundException, Exception{
		return contentDataProvider.getFileHandler(avatarDataProvider.getAvatarGallery(galleryId).getFilePath());
	}
	
	public void saveAvatar(MultipartFile file, Integer userId, Users zfgcUser) throws Exception{
		validateFile(file);
		
		writeFile(file, zfgcUser);											   
	}
	
	private void writeFile(MultipartFile file, Users zfgcUser) throws Exception{
		FileOutputStream stream;
		String extension = StringUtils.substring(file.getOriginalFilename(), StringUtils.lastIndexOf(file.getOriginalFilename(), '.'),file.getOriginalFilename().length() - 1);
		byte[] bytes = file.getBytes();
		
		String newFileName = ZfgcSecurityUtils.generateCryptoString(16) + "-" + zfgcUser.getUsersId() + extension;
		stream = new FileOutputStream("/assets/images/avatar/" + newFileName);
		
		stream.write(bytes);
		
		stream.close();
		
		fileUploadTempDataProvider.createTempRecord(newFileName, zfgcUser.getUsersId());
	}
	
	private void validateFile(MultipartFile file) throws ZfgcInvalidFileException{
		String mimeType = file.getContentType();
		String fileName = file.getOriginalFilename();
		
		if(!mimeType.equals(MediaType.IMAGE_GIF) &&
		   !mimeType.equals(MediaType.IMAGE_JPEG) &&
		   !mimeType.equals(MediaType.IMAGE_PNG)){
			throw new ZfgcInvalidFileException(fileName, ZfgcInvalidFileException.INVALID_FILE_EXT, ".jpg",".jpeg",".gif",".png");
		}
	}
}
