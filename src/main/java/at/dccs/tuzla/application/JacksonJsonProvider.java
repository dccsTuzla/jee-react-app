/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.application;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

/**
 * AppMessageBodyProvider
 *
 * <p>Object mapper resolver. Used to configure serialization / deserialization to achieve that all
 * data is converted properly.
 *
 * <p>MessageBodyProvider as class which implements MessageBodyWriter and MessageBodyReader
 * interfaces is used since these are supported and executed on both needed application servers
 * (WebSphere and TomEE).
 *
 * <p>Method writeTo, which is override is called before data is transferred to the client at the
 * end of every request (part of serialization process).
 *
 * <p>Method readFrom, which is override is called during parsing of request data on the server at
 * the beginning of request where some input data is provided (part of deserialization process)
 */
@Provider
@Consumes({"application/json"})
@Produces({"application/json"})
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {}
