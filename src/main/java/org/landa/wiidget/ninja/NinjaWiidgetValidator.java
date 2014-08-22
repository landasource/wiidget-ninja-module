package org.landa.wiidget.ninja;

import java.util.List;

import org.landa.wiidget.Wiidget;
import org.landa.wiidget.engine.ObjectFactory;
import org.landa.wiidget.validation.DefaultWiidgetValidator;
import org.landa.wiidget.validation.ValidationError;

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
