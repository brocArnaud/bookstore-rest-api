/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:02:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean SynopsisRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class SynopsisRecordTest 
{

	@Test
	public void testSettersAndGetters() {
		
		System.out.println("Checking class SynopsisRecord getters and setters ..." );
		
		SynopsisRecord synopsisRecord = new SynopsisRecord();


		//--- Test setter/getter for attribute "bookId"  ( model type : Integer / wrapperType : Integer )
		synopsisRecord.setBookId( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), synopsisRecord.getBookId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "synopsis"  ( model type : String / wrapperType : String )
		synopsisRecord.setSynopsis( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", synopsisRecord.getSynopsis() ) ; // Not primitive type in model


	}

}
