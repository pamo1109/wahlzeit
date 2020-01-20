/**
 * 
 */
package org.wahlzeit.work;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

/**
 * @author patrickmoritz
 *
 */
public class MountainPhoto extends Photo {
	
	private Mountain mountain = null;
	
	private MountainManager mManager = MountainManager.getInstance();

	/**
	 * 
	 */
	public MountainPhoto() {
		super();
	}

	/**
	 * @param myId
	 */
	public MountainPhoto(PhotoId myId, String type) {
		super(myId);
		mountain = mManager.createMountain(type, myId);
	}

}
