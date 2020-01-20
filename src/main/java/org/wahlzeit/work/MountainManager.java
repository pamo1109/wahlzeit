/**
 * 
 */
package org.wahlzeit.work;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.PhotoId;

/**
 * @author patrickmoritz
 *
 */
public class MountainManager {
	
	protected static final MountainManager instance = new MountainManager();
	
	/**
	 * In-memory cache for photos
	 */
	protected Map<PhotoId, Mountain> mountains = new HashMap<PhotoId, Mountain>();

	public Mountain createMountain(String typeName, PhotoId id) {
		MountainType mt = getMountainType(typeName);
		Mountain result = mt.createInstance();
		mountains.put(id, result);
		return result;
	}
	
	public static final MountainManager getInstance() {
		return instance;
	}

	private MountainType getMountainType(String typeName) {
		return new MountainType(typeName);
	}
	
}
