package com.morgan.design.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;

public class ExampleFileLoaderUnitTest {

	@Test
	public void shouldLoadAllLines() {
		try {
			final String readAllLines = ResourceFileLoader.readAll("sample/test_sql_1.sql");
			assertThat(readAllLines, Is.is("-- Some sql to read"));
		}
		catch (final IOException e) {
			fail("No exception should be found");
		}
		catch (final URISyntaxException e) {
			fail("No exception should be found");
		}
	}

	@Test
	public void shouldLoadLineByLine() {
		try {
			final List<String> readLines = ResourceFileLoader.readLines("sample/test_sql_2.sql");
			assertThat(readLines.get(0), Is.is("-- Some sql to read line 1"));
			assertThat(readLines.get(1), Is.is("-- Some sql to read line 2"));
			assertThat(readLines.get(2), Is.is("-- Some sql to read line 3"));
		}
		catch (final IOException e) {
			fail("No exception should be found");
		}
		catch (final URISyntaxException e) {
			fail("No exception should be found");
		}
	}

}
