/**
 * Additional validators for JSR-349 built-in constraints.
 *  
 * You have to add these validators to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 * @see javax.validation.ConstraintValidator
 * @see <a href="http://beanvalidation.org/1.1/spec/#xml-mapping-constraintdefinition">8.1.2. Overriding constraint definitions in XML</a>
 *  
 *
 */
package org.bongiorno.validation.validator.jsr349;
import javax.validation.Configuration;
