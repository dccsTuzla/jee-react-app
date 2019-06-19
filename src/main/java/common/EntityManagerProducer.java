/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package common;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/** Producer for the default entity manager. */
class EntityManagerProducer {
  @Produces @PersistenceContext private EntityManager em_;
}
