/*
 * @(#)MyRepositoryImpl.java        1.00	22/gen/2015
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
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * La classe <code>MyRepositoryImpl.java</code> &egrave;
 *
 * @author Claudio Maraniello claudio.maraniello@quigroup.it
 * @version 1.00 22/gen/2015
 *
 */
@NoRepositoryBean
public class LoyaltyRepositoryImpl<T extends Fields, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements LoyaltyRepository<T, ID> {

	// There are two constructors to choose from, either can be used.
	public LoyaltyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

	// TODO logicalDelete: this method will override delete(T entity) of
	// SimpleJpaRepository
	// @Override
	public void logicalDelete(T entity) {
		((Fields) entity).setDateDelete(new Date());
		((Fields) entity).setUserDelete(new BigDecimal(0));
		super.save(entity);
	}
}