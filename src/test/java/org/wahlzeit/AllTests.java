package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.wahlzeit.handlers.HandlerTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.services.mailing.MailingTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	HandlerTestSuite.class, 
	ModelTestSuite.class,
	PersistenceTestSuite.class,
	ServicesTestSuite.class,
	MailingTestSuite.class,
	UtilsTestSuite.class})
public class AllTests {

}
