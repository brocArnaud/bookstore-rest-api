/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:14 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.PublisherRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.PublisherJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class PublisherJpaMapper extends AbstractServiceMapper {



	/**
	 * Constructor.
	 */
	public PublisherJpaMapper() {
		super();
	}


	/**
	 * Mapping from 'PublisherJpaRecord' to 'PublisherRecord'
	 * @param entity the mapping input 
	 */
	public PublisherRecord mapEntityToRecord ( PublisherJpaRecord entity) {
		if ( entity == null ) {
			return null;
		}

		//--- Generic mapping 
		PublisherRecord record = map(entity, PublisherRecord.class);

		return record ;
	}

	/**
	 * Mapping from 'PublisherRecord' to 'PublisherJpaRecord' 
	 * @param record the mapping input 
	 * @return
	 */
	public PublisherJpaRecord mapRecordToEntity(PublisherRecord record) {
		if ( record == null ) {
			return null;
		}
		return map(record, PublisherJpaRecord.class);
	}


	/**
	 * Mapping from record 'PublisherRecord' to entity 'PublisherJpaRecord'
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(PublisherRecord record, PublisherJpaRecord entity) {
		if ( record == null ) {
			return;
		}

		//--- Generic mapping 
		map(record, entity);
	}


}