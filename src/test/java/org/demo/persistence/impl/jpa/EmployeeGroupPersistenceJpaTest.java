/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa;

import org.demo.persistence.EmployeeGroupPersistence ;
import org.demo.persistence.EmployeeGroupPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for EmployeeGroup persistence service
 * 
 * @author Telosys Tools
 *
 */
public class EmployeeGroupPersistenceJpaTest extends EmployeeGroupPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	EmployeeGroupPersistence persistenceService = new EmployeeGroupPersistenceJpa();


    	testPersistenceService(persistenceService);
	}	
}
