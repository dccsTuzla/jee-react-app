/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/** Defines the base path for JAX-RS. */
@ApplicationPath("rest")
public class RestApplication extends Application {}
