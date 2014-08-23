/**
 *
 */
package com.landasource.wiidget.ninja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import com.google.inject.Inject;
import com.landasource.wiidget.engine.configuration.ClassPathFileLoader;
import com.landasource.wiidget.io.FileLoader;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class ServletFileLoader implements FileLoader {

	private final ServletContext context;
	private final ClassPathFileLoader classPathFileLoader = new ClassPathFileLoader();;

	@Inject
	public ServletFileLoader(final ServletContext context) {
		this.context = context;

	}

	/*
	 * (non-Javadoc)
	 * @see com.landasource.wiidget.io.FileLoader#getFile(java.lang.String)
	 */
	@Override
	public InputStream getFile(final String path) {

		final String fullPath = context.getRealPath(path);

		try {
			return new FileInputStream(fullPath);
		} catch (final FileNotFoundException e) {
			return classPathFileLoader.getFile(path);
		}
	}

	@Override
	public boolean exists(final String filename) {

		final String fullPath = context.getRealPath(filename);

		final boolean isFile = new File(fullPath).isFile();
		return isFile ? isFile : classPathFileLoader.exists(fullPath);
	}

}
