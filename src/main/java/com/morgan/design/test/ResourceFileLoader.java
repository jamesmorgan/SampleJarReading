package com.morgan.design.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @author James Edward Morgan
 */
public class ResourceFileLoader {

	/**
	 * @param location
	 * @return a {@link String} {@link List} of all lines in the file
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static List<String> readLines(final String location) throws IOException, URISyntaxException {
		return Files.readLines(new File(Resources.getResource(location)
			.toURI()), Charsets.UTF_8);
	}

	/**
	 * @param location
	 * @return The {@link File} Resource
	 * @throws URISyntaxException
	 */
	public static File readFile(final String location) throws URISyntaxException {
		return new File(Resources.getResource(location)
			.toURI());
	}

	/**
	 * @param location
	 * @return String the complete loaded file
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static String readAll(final String location) throws IOException, URISyntaxException {
		final StringBuilder builder = new StringBuilder();
		for (final String line : Files.readLines(new File(Resources.getResource(location)
			.toURI()), Charsets.UTF_8)) {
			builder.append(line);
		}
		return builder.toString();
	}
}
