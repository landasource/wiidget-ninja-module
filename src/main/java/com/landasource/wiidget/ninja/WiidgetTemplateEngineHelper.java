package com.landasource.wiidget.ninja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import ninja.Result;
import ninja.Route;
import ninja.utils.NinjaConstant;

import com.google.inject.Inject;
import com.landasource.wiidget.WiidgetView;
import com.landasource.wiidget.util.WiidgetProperties;

public class WiidgetTemplateEngineHelper {

	private final WiidgetProperties properties;
	private final ServletContext servletContext;

	@Inject
	public WiidgetTemplateEngineHelper(final WiidgetProperties properties, final ServletContext servletContext) {
		this.properties = properties;
		this.servletContext = servletContext;
	}

	public InputStream getResource(final Route route, final Result result) throws FileNotFoundException {

		if (result.getTemplate() == null) {

			final Class<?> controller = route.getControllerClass();

			final String webappDir = servletContext.getRealPath("/");

			final String methodName = route.getControllerMethod().getName();

			final String viewName = methodName + properties.getString(WiidgetProperties.WIIDGET_FILE_EXTENSION);

			// and the final path of the controller will be something like:
			final String resourcePath = String.format("%s%s%s%s%s", webappDir, File.separator, controller.getSimpleName(), File.separator, viewName);

			return new FileInputStream(resourcePath);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <V extends WiidgetView> Class<V> getViewClass(final Route route, final Result result) throws ClassNotFoundException {

		String className = null;

		if (result.getTemplate() == null) {

			final Class<?> controller = route.getControllerClass();

			// Calculate the correct path of the template.
			// We always assume the template in the subdir "views"

			// 1) If we are in the main project =>
			// /controllers/ControllerName
			// to
			// /views/ControllerName/templateName.ftl.html
			// 2) If we are in a plugin / subproject
			// =>
			// /controllers/some/packages/submoduleName/ControllerName
			// to
			// views/some/packages/submoduleName/ControllerName/templateName.ftl.html

			// So let's calculate the parent package of the controller:
			final String controllerPackageName = controller.getPackage().getName();
			// This results in something like controllers or
			// some.package.controllers

			// Replace controller prefix with views prefix
			final String parentPackageOfController = controllerPackageName.replaceFirst(NinjaConstant.CONTROLLERS_DIR, NinjaConstant.VIEWS_DIR);

			// And now we rewrite everything from "." notation to directories /
			final String parentControllerPackageAsPath = parentPackageOfController.replaceAll("\\.", "/");

			final String methodName = route.getControllerMethod().getName();

			final String viewName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);

			// and the final path of the controller will be something like:
			className = String.format("%s.%s.%s", parentControllerPackageAsPath, controller.getSimpleName(), viewName);

		} else {
			className = result.getTemplate();
		}

		return (Class<V>) Class.forName(className);

	}
}
