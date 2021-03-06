/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:02:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean AuthorRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class AuthorRecordTest 
{

	@Test
	public void testSettersAndGetters() {
		
		System.out.println("Checking class AuthorRecord getters and setters ..." );
		
		AuthorRecord authorRecord = new AuthorRecord();


		//--- Test setter/getter for attribute "id"  ( model type : Integer / wrapperType : Integer )
		authorRecord.setId( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), authorRecord.getId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "firstName"  ( model type : String / wrapperType : String )
		authorRecord.setFirstName( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", authorRecord.getFirstName() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "lastName"  ( model type : String / wrapperType : String )
		authorRecord.setLastName( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", authorRecord.getLastName() ) ; // Not primitive type in model


	}

}
