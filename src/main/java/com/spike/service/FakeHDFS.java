package com.spike.service;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/12/14
 */
@BindingAnnotation
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeHDFS {
}
