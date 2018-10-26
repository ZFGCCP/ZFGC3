package com.zfgc.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.services.avatar.AvatarService;

@Component
public class ContentDataProvider extends AbstractDataProvider{
	
	@Autowired
	AvatarService avatarService;
	
	public InputStreamWrapper getAvatarHandle(Integer avatarId) throws ZfgcNotFoundException, FileNotFoundException {
		String fileName = avatarService.getAvatarFileName(avatarId);
		if (fileName == null){
			throw new ZfgcNotFoundException("Avatar " + avatarId);
		}
		
		InputStream stream = null;
		try {
			stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		}

		InputStreamWrapper wrapper = new InputStreamWrapper();
		wrapper.setFileName(fileName);
		wrapper.setIs(stream);
		
		return wrapper;
	}
	
	public InputStreamWrapper getFileHandler(String fileName) throws FileNotFoundException {
		InputStream stream = null;
		try {
			stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		}

		InputStreamWrapper wrapper = new InputStreamWrapper();
		wrapper.setFileName(fileName);
		wrapper.setIs(stream);
		
		return wrapper;
	}
}
