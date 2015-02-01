/*
 * @(#)MyRepository.java        1.00	22/gen/2015
 *
 * Copyright (c) 2007-2014 QuiGroup,
 *
 * This software is the confidential and proprietary information of QuiGroup 
 * Networks srl, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with QuiGroup.
 */

package it.mexican.demo.springdatajpa.factory;

import it.mexican.demo.springdatajpa.entities.Fields;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * La classe <code>MyRepository.java</code> &egrave;
 *
 * @author Claudio Maraniello claudio.maraniello@quigroup.it
 * @version 1.00	22/gen/2015
 * @param <T>
 *
 */
@NoRepositoryBean
public interface LoyaltyRepository<T extends Fields, ID extends Serializable > extends Repository<T, ID> {
	
	<S extends T> S save(S entity);
	
	T findOne(ID id);
	
	boolean exists(ID id);
	
	Iterable<T> findAll();
	
	long count();
	
	void delete(ID id);

}
