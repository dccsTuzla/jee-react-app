/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.resource;

import at.dccs.tuzla.projection.UserProjection;
import at.dccs.tuzla.service.UserService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/** REST resource for managing Users. */
@ApplicationScoped
@Transactional
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
  @Inject private UserService userService;

  @GET
  public List<UserProjection> getAllUsers() {
    return userService.getUsers();
  }
}
