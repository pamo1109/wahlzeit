/**
 * 
 */
package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.annotations.PatternInstance;

/**
 * @author patrickmoritz
 *
 */
@PatternInstance(
		patternName = "Singleton",
		participants = {"Leaf", "ConcreteProduct"}
)
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
