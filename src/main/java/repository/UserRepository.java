/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package repository;

import entity.UserEntity;
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
  @Inject private EntityManager entityManager_;

  public List<UserEntity> getUsers() {
    CriteriaBuilder cb = entityManager_.getCriteriaBuilder();
    CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
    query.from(UserEntity.class);
    return entityManager_.createQuery(query).getResultList();
  }
}
