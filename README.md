[![My Stack Overflow Profile][2]][1] 

  [1]: http://stackexchange.com/users/673865
  [2]: http://stackoverflow.com/users/flair/889053.png

# Validation
This library provides a set of additional bean validation (JSR 349 formerly JSR 303) constraints and validators.
You find the constraints in the package
[`org.bongiorno.validation.constraints`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/package-summary.html):

* [`@Age`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/age/Age.html): The Date must be in the past and at least that years old.
* [`@Adult`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/age/Adult.html): The Date must be at least 18 years old.
* [`@BIC`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/banking/BIC.html): The String must be a valid BIC (Business Identifier Code) address.
* [`@IBAN`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/banking/IBAN.html): The String must be a valid IBAN (International Bank Account Number) address.
* [`@BitcoinAddress`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/banking/BitcoinAddress.html): Validates a bitcoin address.
* [`@TLD`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/net/TLD.html): The String is a Top Level Domain.
* [`@Domain`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/net/Domain.html): The String has to be a Domain.
* [`@IPv4`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/net/IPv4.html): The String has to be an IPv4 address.
* [`@ContentType`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/upload/ContentType.html): The Spring `MultipartFile` must match a ContentType. You have to provide javax.mail for the matching.
* [`@Image`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/upload/Image.html): The Spring `MultipartFile` must be an image.
* [`@NotEmptyBlob`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/upload/NotEmptyBlob.html): The `Blob` must not be empty (but can be null).
* [`@Country`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/Country.html): The String has to be a well formed ISO-3166-1 alpha-2 country code.
* [`@EqualProperties`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/EqualProperties.html): The bean has properties with equal values (e.g. two identical passwords).
* [`@ISBN`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/constraints/ISBN.html): The String has to be an ISBN (International Standard Book Number).

# Optional Dependencies
Some constraints require further dependencies. If you want to use them you
have to provide those dependencies:

* `org.bongiorno.validation.constraints.upload.*` requires `org.springframework.web` and `javax.mail.mail`.

# Additional Validators for JSR-349 built-ins
[`org.bongiorno.validation.validator.jsr349`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/validator/jsr349/package-summary.html)
extends some JSR-349 built-in constraints with validators for additional types:

* [`SizeValidatorForMultipartFile`](http://malkusch.github.io/validation/apidocs/de/malkusch/validation/validator/jsr349/size/SizeValidatorForMultipartFile.html): Validates a `@Size` constraint against a Spring `MultipartFile`.
* `PastValidatorFor…`: Validates a `@Past` constraint against `java.time` (JSR 310: Date and Time API) objects.
* `FutureValidatorFor…`: Validates a `@Future` constraint against `java.time` (JSR 310: Date and Time API) objects.

If you want to use these validators you have to include the mapping
resource **META-INF/validation/mapping.xml**. This can be done by 
preferably create the file **META-INF/validation.xml**
and add that mapping or you do it programmatically with `Configuration.addMapping(java.io.InputStream)`:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<validation-config
    xmlns="http://jboss.org/xml/ns/javax/validation/configuration"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://jboss.org/xml/ns/javax/validation/configuration validation-configuration-1.1.xsd">
    
    <constraint-mapping>META-INF/validation/mapping.xml</constraint-mapping>
</validation-config>
```

# Maven
You find this package in Maven central:
```xml
<dependency>
    <groupId>org.bongiorno.validation</groupId>
    <artifactId>validation</artifactId>
    <version>1.0.0</version>
</dependency>
```


# License and author

Christian Bongiorno <christian.bongiorno@gmail.com> is the author of this project. This project is free and under the WTFPL.


