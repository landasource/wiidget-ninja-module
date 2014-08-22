package com.landasource.wiidget.ninja;

import ninja.template.TemplateEngine;

import com.landasource.wiidget.context.WiidgetContext;
import com.landasource.wiidget.engine.ObjectFactory;
import com.landasource.wiidget.engine.configuration.Configuration;
import com.landasource.wiidget.url.TransparentURLResolver;
import com.landasource.wiidget.url.URLResolver;
import com.landasource.wiidget.util.WiidgetProperties;
import com.landasource.wiidget.validation.WiidgetValidator;

import com.google.inject.AbstractModule;

public class WiidgetModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(TemplateEngine.class).to(WiidgetTemplateEngine.class);

		bind(ObjectFactory.class).to(GuiceObjectFactory.class);
		bind(WiidgetValidator.class).to(NinjaWiidgetValidator.class);
		bind(WiidgetProperties.class).to(NinjaWiidgetProperties.class);
		bind(WiidgetContext.class).to(NinjaWiidgetContext.class);
		bind(URLResolver.class).to(TransparentURLResolver.class);

		bind(Configuration.class).to(NinjaConfiguration.class);
	}
}
