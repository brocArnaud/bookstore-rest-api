/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa;

import org.demo.persistence.BookOrderPersistence ;
import org.demo.persistence.BookOrderPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for BookOrder persistence service
 * 
 * @author Telosys Tools
 *
 */
public class BookOrderPersistenceJpaTest extends BookOrderPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BookOrderPersistence persistenceService = new BookOrderPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}