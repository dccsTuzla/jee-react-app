/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import projection.UserProjection;
import service.UserService;

/** REST resource for managing Users. */
@Stateless
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
  @Inject private UserService userService_;

  @GET
  public List<UserProjection> getAllUsers() {
    return userService_.getUsers();
  }
}
