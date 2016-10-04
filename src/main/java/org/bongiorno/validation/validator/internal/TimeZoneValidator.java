package org.bongiorno.validation.validator.internal;


import org.bongiorno.validation.constraints.TimeZone;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

import java.time.ZoneId;

public class TimeZoneValidator extends AbstractConstraintValidator<TimeZone,String> {

    public TimeZoneValidator() {
        super((v,c) -> ZoneId.getAvailableZoneIds().contains(v));
    }
}
