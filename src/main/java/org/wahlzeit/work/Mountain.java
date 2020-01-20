/**
 * 
 */
package org.wahlzeit.work;

import org.wahlzeit.model.PhotoId;

/**
 * @author patrickmoritz
 *
 */
public class Mountain {
	
	protected MountainType mountainType = null;
	
	public Mountain(MountainType mt) {
		mountainType = mt;
	}

	public MountainType getType() {
		return mountainType;
	}
}
