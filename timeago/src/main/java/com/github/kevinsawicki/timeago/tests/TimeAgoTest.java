package com.github.kevinsawicki.timeago.tests;
/*
 * Copyright (c) 2011 Kevin Sawicki <kevinsawicki@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
import com.github.kevinsawicki.timeago.TimeAgo;

import java.text.MessageFormat;

import junit.framework.TestCase;

/**
 *
 * Unit tests of {@link TimeAgo}
 */
public class TimeAgoTest extends TestCase {

	/**
	 * One second in milliseconds
	 */
	public static final long SECOND = 1000;

	/**
	 * One minute in milliseconds
	 */
	public static final long MINUTE = 60 * SECOND;

	/**
	 * One hour in milliseconds
	 */
	public static final long HOUR = 60 * MINUTE;

	/**
	 * One day in milliseconds
	 */
	public static final long DAY = 24 * HOUR;

	/**
	 * 30 days in milliseconds
	 */
	public static final long MONTH = 30 * DAY;

	/**
	 * 365 days in milliseconds
	 */
	public static final long YEAR = 365 * DAY;

	/**
	 * Locale for test
	 */
	private static final String locale = "it";

	private long ago(long offset) {
		return System.currentTimeMillis() - offset;
	}

	/**
	 * Test seconds ago
	 */
	public void testAgoSeconds() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(System.currentTimeMillis());
		String expected = ago.join(ago.getPrefixAgo(), ago.getSeconds(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test minute ago
	 */
	public void testAgoMinute() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(ago(MINUTE));
		String expected = ago.join(ago.getPrefixAgo(), ago.getMinute(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test minutes ago
	 */
	public void testAgoMinutes() {
		TimeAgo ago = new TimeAgo(locale);
		int minutes = 2;
		String time = ago.timeAgo(ago(minutes * MINUTE));
		String expected = ago.join(ago.getPrefixAgo(),
				MessageFormat.format(ago.getMinutes(), minutes),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test hour ago
	 */
	public void testAgoHour() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(ago(HOUR));
		String expected = ago.join(ago.getPrefixAgo(), ago.getHour(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test hours ago
	 */
	public void testAgoHours() {
		TimeAgo ago = new TimeAgo(locale);
		long hours = 3;
		String time = ago.timeAgo(ago(hours * HOUR));
		String expected = ago
				.join(ago.getPrefixAgo(),
						MessageFormat.format(ago.getHours(), hours),
						ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test day ago
	 */
	public void testAgoDay() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(ago(30 * HOUR));
		String expected = ago.join(ago.getPrefixAgo(), ago.getDay(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test day ago
	 */
	public void testAgoDays() {
		TimeAgo ago = new TimeAgo(locale);
		long days = 4;
		String time = ago.timeAgo(ago(days * DAY));
		String expected = ago.join(ago.getPrefixAgo(),
				MessageFormat.format(ago.getDays(), days), ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test month ago
	 */
	public void testAgoMonth() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(ago(35 * DAY));
		String expected = ago.join(ago.getPrefixAgo(), ago.getMonth(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test months ago
	 */
	public void testAgoMonths() {
		TimeAgo ago = new TimeAgo(locale);
		long months = 2;
		String time = ago.timeAgo(ago(months * MONTH));
		String expected = ago.join(ago.getPrefixAgo(),
				MessageFormat.format(ago.getMonths(), months),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test year ago
	 */
	public void testYearAgo() {
		TimeAgo ago = new TimeAgo(locale);
		String time = ago.timeAgo(System.currentTimeMillis() - (14 * MONTH));
		String expected = ago.join(ago.getPrefixAgo(), ago.getYear(),
				ago.getSuffixAgo());
		assertEquals(expected, time);
	}

	/**
	 * Test year ago
	 */
	public void testYearsAgo() {
		TimeAgo ago = new TimeAgo(locale);
		long years = 7;
		String time = ago.timeAgo(System.currentTimeMillis() - (years * YEAR));
		String expected = ago
				.join(ago.getPrefixAgo(),
						MessageFormat.format(ago.getYears(), years),
						ago.getSuffixAgo());
		assertEquals(expected, time);
	}
}