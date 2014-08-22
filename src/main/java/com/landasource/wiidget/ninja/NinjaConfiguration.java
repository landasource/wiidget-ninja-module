package com.landasource.wiidget.ninja;

import com.landasource.wiidget.engine.ObjectFactory;
import com.landasource.wiidget.engine.configuration.DefaultConfiguration;
import com.landasource.wiidget.url.URLResolver;
import com.landasource.wiidget.validation.WiidgetValidator;

/**
 *
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 *
 */
public class NinjaConfiguration extends DefaultConfiguration {

	private final URLResolver urlResolver;
	private final WiidgetValidator wiidgetValidator;
	private final ObjectFactory objectFactory;

	@com.google.inject.Inject
	public NinjaConfiguration(final URLResolver urlResolver, final WiidgetValidator wiidgetValidator, final ObjectFactory objectFactory) {
		this.urlResolver = urlResolver;
		this.wiidgetValidator = wiidgetValidator;
		this.objectFactory = objectFactory;

	}

	@Override
	public URLResolver getUrlResolver() {
		return urlResolver;
	}

	@Override
	public WiidgetValidator getWiidgetValidator() {
		return wiidgetValidator;
	}

	@Override
	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

}
