package com.morgan.design.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @author James Edward Morgan
 */
public class TestingVariousSampleJarReading {

	public static void main(final String[] args) {

		System.out.println("Test main method -- Reaidng file");
		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read file with no relative path");
			System.out.println(Files.readLines(new File("src/main/sql/sample/test_sql.sql"), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read file with no relative path Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read file with relative path and slash");
			final String fileLocationWithSlash = TestingVariousSampleJarReading.class.getClassLoader()
				.getResource("/sample/test_sql.sql")
				.getFile();
			System.out.println("fileLocationWithSlash : " + fileLocationWithSlash);
			System.out.println(Files.readLines(new File(fileLocationWithSlash), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read file with relative path and slash Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read file with relative path");
			final String fileLocationWithoutSlash = TestingVariousSampleJarReading.class.getClassLoader()
				.getResource("sample/test_sql.sql")
				.getFile();
			System.out.println("fileLocationWithoutSlash : " + fileLocationWithoutSlash);
			System.out.println(Files.readLines(new File(fileLocationWithoutSlash), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read file with relative path Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read file in same path from class path");
			final ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
			final String fileName = classLoader.getResource("sample/test_sql.sql")
				.getFile();
			System.out.println("fileName : " + fileName);
			System.out.println(Files.readLines(new File(fileName), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read file in same path from class path Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read file in direct path from class path");
			final ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
			final String fileName = classLoader.getResource("src/main/sql/sample/test_sql.sql")
				.getFile();
			System.out.println("fileName : " + fileName);
			System.out.println(Files.readLines(new File(fileName), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read file in direct path from class path Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read readTextFromJar 2 ");
			final List<String> readTextFromJar = readTextFromJar("/src/main/sql/sample/test_sql.sql");
			System.out.println("filereadTextFromJarName 2: " + readTextFromJar);
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("readTextFromJar 2 Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read with slash ");
			final File file = new File(TestingVariousSampleJarReading.class.getClass()
				.getResource("/sample/test_sql.sql")
				.getFile());
			System.out.println(Files.readLines(file, Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read with slash Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("displayResource ");
			final TestingVariousSampleJarReading objRes = new TestingVariousSampleJarReading();
			objRes.displayResource("/sample/test_sql.sql");
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("displayResource Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read readTextFromJar");
			final List<String> readTextFromJar = readTextFromJar("/sample/test_sql.sql");
			System.out.println("filereadTextFromJarName : " + readTextFromJar);
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("readTextFromJar Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read Resources");
			System.out.println("Resources : " + Resources.readLines(Resources.getResource("/sample/test_sql.sql"), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read Resources Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read Resources");
			System.out.println("Resources : " + Resources.readLines(Resources.getResource("sample/test_sql.sql"), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read Resources Failed....!!!!!!!!!!");
		}

		try {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Read Resources");
			System.out.println("Resources : "
				+ Resources.readLines(Resources.getResource("/src/main/sql/sample/test_sql.sql"), Charsets.UTF_8));
			System.out.println("----------------------------------------------------------------------------");
		}
		catch (final Exception e) {
			System.out.println("Read Resources Failed....!!!!!!!!!!");
		}

	}

	public static List<String> readTextFromJar(final String s) {
		InputStream is = null;
		BufferedReader br = null;
		String line;
		final List<String> list = new ArrayList<String>();

		try {
			is = TestingVariousSampleJarReading.class.getResourceAsStream(s);
			br = new BufferedReader(new InputStreamReader(is));
			while (null != (line = br.readLine())) {
				list.add(line);
			}
		}
		catch (final Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null)
					br.close();
				if (is != null)
					is.close();
			}
			catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private void displayResource(final String strName) {
		try {
			final BufferedReader objBin = new BufferedReader(new InputStreamReader(this.getClass()
				.getResourceAsStream(strName)));
			String strLine = null;
			while ((strLine = objBin.readLine()) != null) {
				System.out.println(strLine);
			}
			objBin.close();
		}
		catch (final Exception e) {
			System.out.println(e);
		}
	}

}
