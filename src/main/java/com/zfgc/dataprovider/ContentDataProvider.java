package com.zfgc.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.content.InputStreamWrapper;
import com.zfgc.services.avatar.AvatarService;

@Component
public class ContentDataProvider extends AbstractDataProvider{
	
	@Autowired
	AvatarService avatarService;
	
	@Value("${zfgc.general.avatarDirectory}")
	private String avatarDirectory;
	
	public InputStreamWrapper getAvatarHandle(Integer avatarId) throws ZfgcNotFoundException, FileNotFoundException {
		
		String fileName = avatarDirectory + "\\avatar-none.png";
		
		if(avatarId > -1) {
			fileName = avatarService.getAvatarFileName(avatarId);
			if (fileName == null){
				throw new ZfgcNotFoundException("Avatar " + avatarId);
			}
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
	
	public InputStreamWrapper getFileHandler(String fileName) throws ZfgcNotFoundException {
		InputStream stream = null;
		try {
			stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			throw new ZfgcNotFoundException(e.getMessage());
		}

		InputStreamWrapper wrapper = new InputStreamWrapper();
		wrapper.setFileName(fileName);
		wrapper.setIs(stream);
		
		return wrapper;
	}
}
