/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa;

import org.demo.persistence.BookOrderItemPersistence ;
import org.demo.persistence.BookOrderItemPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for BookOrderItem persistence service
 * 
 * @author Telosys Tools
 *
 */
public class BookOrderItemPersistenceJpaTest extends BookOrderItemPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	BookOrderItemPersistence persistenceService = new BookOrderItemPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
