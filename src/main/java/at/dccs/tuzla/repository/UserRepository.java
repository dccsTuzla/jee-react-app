/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.repository;

import at.dccs.tuzla.entity.UserEntity;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * UserRepository
 *
 * <p>User Database Interface
 */
public class UserRepository {
  @Inject private EntityManager entityManager;

  public List<UserEntity> getUsers() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
    query.from(UserEntity.class);
    return entityManager.createQuery(query).getResultList();
  }
}
