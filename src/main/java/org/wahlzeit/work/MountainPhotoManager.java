/**
 * 
 */
package org.wahlzeit.work;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.wahlzeit.annotations.PatternInstance;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;

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
	
	/**
	 * In-memory cache for photos
	 */
	protected Map<PhotoId, MountainPhoto> photoCache = new HashMap<PhotoId, MountainPhoto>();


	private static final Logger log = Logger.getLogger(MountainPhotoManager.class.getName());

	/**
	/**
	 *
	 */
	public MountainPhotoManager() {
		super();
	}

	/**
	 *
	 */
	public static final MountainPhotoManager getInstance() {
		return instance;
	}

}
