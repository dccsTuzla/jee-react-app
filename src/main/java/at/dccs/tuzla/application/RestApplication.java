/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/** Defines the base path for JAX-RS. */
@ApplicationPath("rest")
public class RestApplication extends Application {}
