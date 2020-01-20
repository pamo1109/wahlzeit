/**
 * 
 */
package org.wahlzeit.work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

/**
 * @author patrickmoritz
 *
 */
public class MountainType extends DataObject {
	protected MountainType superType = null;
	protected Set<MountainType> subTypes = new HashSet<MountainType>();
	
	private String name = null;
	
	public MountainType(String type) {
		name = type;
	}
	
	public Mountain createInstance() {
		return new Mountain(this);
	}
	
	public MountainType getSuperType() {
		return superType;
	}
	
	public void setSuperType(MountainType mt) {
		superType = mt;
	}
	
	public Iterator<MountainType> getSubTypeIterator() {
		return subTypes.iterator();
	}
	
	public void addSubType(MountainType mt) {
		assert (mt != null) : "tried to set null sub-type";
		mt.setSuperType(this);
		subTypes.add(mt);
	}
	
	public boolean hasInstance(Mountain mountain) {
		assert (mountain != null) : "asked about null object";
		if (mountain.getType() == this) {
			return true;
		}
		
		for (MountainType mt : subTypes) {
			if(mt.hasInstance(mountain)) {
				return true;
			}
		}
		
		return false;
	}

}
