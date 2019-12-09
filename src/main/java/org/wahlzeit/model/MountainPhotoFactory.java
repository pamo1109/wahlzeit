/**
 * 
 */
package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * @author patrickmoritz
 *
 */
public class MountainPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(MountainPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static MountainPhotoFactory instance = null;
	
	/**
	 * 
	 */
	public MountainPhotoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic MountainPhotoFactory").toString());
			setInstance(new PhotoFactory());
		}

		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(MountainPhotoFactory mPhotoFactory) throws IllegalStateException {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize MountainPhotoFactory twice");
		}

		instance = mPhotoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	public MountainPhoto createPhoto() {
		return new MountainPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public MountainPhoto createPhoto(PhotoId id) {
		return new MountainPhoto(id);
	}

}
