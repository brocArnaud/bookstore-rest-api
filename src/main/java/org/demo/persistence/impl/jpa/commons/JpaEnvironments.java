/*
 * Created on 2017-11-03 ( Date ISO 2017-11-03 - Time 15:03:19 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.jpa.commons;


import java.util.HashMap;
import java.util.Map;

public class JpaEnvironments {

	private final static JpaEnvironments singleInstance = new JpaEnvironments();
	
	private final Map<String,JpaEnvironment> environments ;
	private final String                     defaultPersistenceUnitName ;

	private JpaEnvironments() {
		super();
		this.environments = new HashMap<String,JpaEnvironment>();
		JpaPersistenceConfig config = new JpaPersistenceConfig() ;
		defaultPersistenceUnitName = config.getPersistenceUnitName();
	}
	
	/**
	 * Return the single instance of this class
	 * @return
	 */
	public final static JpaEnvironments getInstance() {
		return singleInstance ;
	}
	
	/**
	 * Returns a JpaEnvironment for the default peristence unit name
	 * @return
	 */
	public JpaEnvironment getJpaEnvironment() {
		return getJpaEnvironment( defaultPersistenceUnitName );
	}

	/**
	 * Returns a JpaEnvironment for the given peristence unit name
	 * @param peristenceUnitName
	 * @return
	 */
	public JpaEnvironment getJpaEnvironment(final String peristenceUnitName ) {
		JpaEnvironment env = environments.get(peristenceUnitName) ;
		if ( env == null ) {
			env = createNewJpaEnvironment( peristenceUnitName );
		}
		return env ;
	}

	private synchronized JpaEnvironment createNewJpaEnvironment(final String peristenceUnitName ) {
		JpaEnvironment env = environments.get(peristenceUnitName) ; // double check 
		if ( env == null ) {
			env = new JpaEnvironment(peristenceUnitName);
			environments.put(peristenceUnitName, env);
		}
		return env ;
	}
}
