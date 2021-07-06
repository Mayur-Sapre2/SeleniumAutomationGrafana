package com.selenium.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.selenium.enus.Authors;
import com.selenium.enus.CategoryType;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * Jun 29, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 * @see com.selenium.AdminConsolePageTest
 * @see com.selenium.enus.CategoryType
 */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
	/**
	 * Store the authors who created the tests in String[]
	 * Manadatory to enter atleast a value
	 * @author Mayur Sapre
	 * Jun 29, 2021
	 */
	public Authors[] author();
	
	/**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.selenium.enus.CategoryType}
	 * @author Amuthan Sakthivel
	 * Jun 29, 2021
	 */
	public CategoryType[] category();
}