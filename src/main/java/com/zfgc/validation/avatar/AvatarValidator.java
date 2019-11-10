package com.zfgc.validation.avatar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.zfgc.model.avatar.AvatarStaging;
import com.zfgc.rules.Rule;
import com.zfgc.util.ZfgcCollectionUtils;
import com.zfgc.validation.AbstractValidator;

@Component
public class AvatarValidator extends AbstractValidator<AvatarStaging> {

	@Override
	public void validator(AvatarStaging model) throws RuntimeException {
		//check file size
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(model.getFile().getInputStream());
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			
			
			if (!iter.hasNext()) {
				Rule invalidFile = new Rule();
				invalidFile.setRuleName("INVALID_IMAGE_FILE");
				invalidFile.setErrorMessage("The file uploaded was an invalid image.");
		        model.getErrors().getValidationErrors().add(invalidFile);
		        return;
		    }

			BufferedImage image = ImageIO.read(iis);
		    
		    if(image == null) {
		    	Rule invalidFile = new Rule();
				invalidFile.setRuleName("INVALID_IMAGE_FILE");
				invalidFile.setErrorMessage("The file uploaded was an invalid image.");
		        model.getErrors().getValidationErrors().add(invalidFile);
		        return;
			}
			
			ImageReader reader = (ImageReader) iter.next();
		    
		    String formatName = reader.getFormatName().toLowerCase();
		    if(!ZfgcCollectionUtils.CoalesceEquals(formatName, "jpg", "jpeg", "png", "gif")) {
		    	Rule invalidFile = new Rule();
				invalidFile.setRuleName("INVALID_IMAGE_FORMAT");
				invalidFile.setErrorMessage("You may only upload a png, jpg, jpeg or gif.");
		        model.getErrors().getValidationErrors().add(invalidFile);
		        return;
		    }
		    int fileSize = model.getFile().getBytes().length;
			if(fileSize > 100000) {
				Rule invalidFile = new Rule();
				invalidFile.setRuleName("INVALID_FILE_SIZE");
				invalidFile.setErrorMessage("Images may not be more than 100kb.");
		        model.getErrors().getValidationErrors().add(invalidFile);
			}
				
			if(image.getWidth() > 150 || image.getHeight() > 150) {
				Rule invalidFile = new Rule();
				invalidFile.setRuleName("INVALID_IMAGE_SIZE");
				invalidFile.setErrorMessage("Images may not be more than 150px by 150px");
		        model.getErrors().getValidationErrors().add(invalidFile);
			}
		
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
