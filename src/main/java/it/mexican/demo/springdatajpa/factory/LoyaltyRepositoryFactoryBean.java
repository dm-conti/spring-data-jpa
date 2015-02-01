/*
 * @(#)MyRepositoryFactoryBean.java        1.00	22/gen/2015
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

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class LoyaltyRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
  extends JpaRepositoryFactoryBean<R, T, I> {

  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {

    return new LoyaltyRepositoryFactory(entityManager);
  }

  private static class LoyaltyRepositoryFactory extends JpaRepositoryFactory {

    private EntityManager entityManager;

    public LoyaltyRepositoryFactory(EntityManager entityManager) {
      super(entityManager);

      this.entityManager = entityManager;
    }

    protected Object getTargetRepository(RepositoryMetadata metadata) {

      return new LoyaltyRepositoryImpl<Fields, Serializable>((Class<Fields>) metadata.getDomainType(), entityManager);
    }

    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

      // The RepositoryMetadata can be safely ignored, it is used by the JpaRepositoryFactory
      //to check for QueryDslJpaRepository's which is out of scope.
      return LoyaltyRepository.class;
    }
  }
}