/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:19 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa;

import org.demo.persistence.WorkgroupPersistence ;
import org.demo.persistence.WorkgroupPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for Workgroup persistence service
 * 
 * @author Telosys Tools
 *
 */
public class WorkgroupPersistenceJpaTest extends WorkgroupPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	WorkgroupPersistence persistenceService = new WorkgroupPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}