/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:02:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.commons;

import org.demo.commons.ImplementationProvider;

/**
 * Persistence service provider 
 * 
 * @author Telosys
 *
 */
public class PersistenceServiceProvider {

	private final static ImplementationProvider provider = new ImplementationProvider(PersistenceServicePattern.PATTERN);
	
	/**
	 * Returns the persistence service implementing the given interface
	 * @param interfaceClass
	 * @return
	 */
	public final static <T> T getService(Class<T> interfaceClass) {
		return provider.getServiceInstance(interfaceClass);
	}
	
}
