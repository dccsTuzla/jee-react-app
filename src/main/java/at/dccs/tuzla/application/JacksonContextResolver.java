/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Context resolver for the Jackson json handling library. This resolver is used to hook into the
 * JAX-RS system. It depends on a specific version of Jackson (currently used in Wildfly and our
 * TomEE configuration).
 */
@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
  private final ObjectMapper mapper;

  /** Create a local mapping configuration. */
  public JacksonContextResolver() {
    this.mapper = createObjectMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return this.mapper;
  }

  /**
   * Producer Method for an ObjectMapper instance. The Mapper itself is stateless and handles
   * LocalDates, ... gracefully. Also for our application this mapper ignores unknown properties. To
   * debug one can hook into the specific Jackson implementations (like LocalDateSerializer, etc.)
   *
   * @return the Jackson Object Mapper to use.
   */
  public static ObjectMapper createObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();

    JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addDeserializer(
        LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE));
    javaTimeModule.addSerializer(
        LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
    javaTimeModule.addSerializer(
        ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    javaTimeModule.addDeserializer(ZonedDateTime.class, InstantDeserializer.ZONED_DATE_TIME);
    javaTimeModule.addSerializer(OffsetDateTime.class, OffsetDateTimeSerializer.INSTANCE);
    javaTimeModule.addDeserializer(OffsetDateTime.class, InstantDeserializer.OFFSET_DATE_TIME);

    mapper.registerModule(javaTimeModule);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
    mapper.registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));

    return mapper;
  }
}
