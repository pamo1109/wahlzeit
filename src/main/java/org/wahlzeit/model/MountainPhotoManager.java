/**
 * 
 */
package org.wahlzeit.model;

import java.util.logging.Logger;

/**
 * @author patrickmoritz
 *
 */
public class MountainPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final MountainPhotoManager instance = new MountainPhotoManager();

	private static final Logger log = Logger.getLogger(MountainPhotoManager.class.getName());

	/**
	/**
	 *
	 */
	public MountainPhotoManager() {
		photoTagCollector = MountainPhotoFactory.getInstance().createPhotoTagCollector();
	}

	/**
	 *
	 */
	public static final MountainPhotoManager getInstance() {
		return instance;
	}

}
