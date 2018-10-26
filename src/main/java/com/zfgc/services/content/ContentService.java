package com.zfgc.services.content;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.AvatarDataProvider;
import com.zfgc.dataprovider.ContentDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.services.AbstractService;

@Component
public class ContentService extends AbstractService{
	@Autowired
	ContentDataProvider contentDataProvider;
	
	@Autowired
	AvatarDataProvider avatarDataProvider;
	
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
}
