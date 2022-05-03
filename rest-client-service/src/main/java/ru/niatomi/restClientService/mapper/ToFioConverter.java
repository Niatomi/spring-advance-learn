package ru.niatomi.restClientService.mapper;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author niatomi
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@Qualifier
public @interface ToFioConverter {
}
