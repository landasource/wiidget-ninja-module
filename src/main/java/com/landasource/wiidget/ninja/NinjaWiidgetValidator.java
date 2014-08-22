package com.landasource.wiidget.ninja;

import java.util.List;

import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.engine.ObjectFactory;
import com.landasource.wiidget.validation.DefaultWiidgetValidator;
import com.landasource.wiidget.validation.ValidationError;

import com.google.inject.Inject;

public class NinjaWiidgetValidator extends DefaultWiidgetValidator {

    //  private final Validation validation;

    //    @Inject
    //    public NinjaWiidgetValidator(final Validation validation, final ObjectFactory objectFactory) {
    //        super(objectFactory);
    //        this.validation = validation;
    //    }

    @Override
    public List<ValidationError> validate(final Wiidget wiidget) {

        return super.validate(wiidget);

    }

    @Inject
    public NinjaWiidgetValidator(final ObjectFactory objectFactory) {
        super(objectFactory);
    }

}
