/*
 * Created on 2017-11-09 ( Date ISO 2017-11-09 - Time 10:26:30 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.EmployeeRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.EmployeeJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class EmployeeJpaMapper extends AbstractServiceMapper {



	/**
	 * Constructor.
	 */
	public EmployeeJpaMapper() {
		super();
	}


	/**
	 * Mapping from 'EmployeeJpaRecord' to 'EmployeeRecord'
	 * @param entity the mapping input 
	 */
	public EmployeeRecord mapEntityToRecord ( EmployeeJpaRecord entity) {
		if ( entity == null ) {
			return null;
		}

		//--- Generic mapping 
		EmployeeRecord record = map(entity, EmployeeRecord.class);

		return record ;
	}

	/**
	 * Mapping from 'EmployeeRecord' to 'EmployeeJpaRecord' 
	 * @param record the mapping input 
	 * @return
	 */
	public EmployeeJpaRecord mapRecordToEntity(EmployeeRecord record) {
		if ( record == null ) {
			return null;
		}
		return map(record, EmployeeJpaRecord.class);
	}


	/**
	 * Mapping from record 'EmployeeRecord' to entity 'EmployeeJpaRecord'
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(EmployeeRecord record, EmployeeJpaRecord entity) {
		if ( record == null ) {
			return;
		}

		//--- Generic mapping 
		map(record, entity);
	}


}