package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MountainPhotoTest {

	@Test
	public void doTestIdConstructor() {
		PhotoId pid = PhotoId.getNextId();
		MountainPhoto mPhoto = new MountainPhoto(pid);
		assertTrue(mPhoto.getId().isEqual(pid));
	}

}
