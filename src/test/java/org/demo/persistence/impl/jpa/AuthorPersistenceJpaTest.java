/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:13 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa;

import org.demo.persistence.AuthorPersistence ;
import org.demo.persistence.AuthorPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Author persistence service
 * 
 * @author Telosys Tools
 *
 */
public class AuthorPersistenceJpaTest extends AuthorPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	AuthorPersistence persistenceService = new AuthorPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
