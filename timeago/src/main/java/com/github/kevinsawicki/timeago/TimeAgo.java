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
package com.github.kevinsawicki.timeago;

import java.text.MessageFormat;
import java.util.Date;

/**
 * 
 * Time ago class that converts long millisecond and {@link Date} objects to
 * time ago/from now {@link String} objects.
 * 
 * This class uses the messages from {@link Messages} by default but those can
 * be changed after creation through one of the setter methods for a specified
 * time string.
 */
public class TimeAgo {

	private String prefixAgo = null;
	private String prefixFromNow = null;
	private String suffixAgo = Messages.getString("TimeAgo.AGO"); //$NON-NLS-1$;
	private String suffixFromNow = Messages
			.getString("TimeAgo.SUFFIX_FROM_NOW"); //$NON-NLS-1$;
	private String seconds = Messages.getString("TimeAgo.SECONDS"); //$NON-NLS-1$
	private String minute = Messages.getString("TimeAgo.MINUTE"); //$NON-NLS-1$
	private String minutes = Messages.getString("TimeAgo.MINUTES"); //$NON-NLS-1$
	private String hour = Messages.getString("TimeAgo.HOUR"); //$NON-NLS-1$;
	private String hours = Messages.getString("TimeAgo.HOURS"); //$NON-NLS-1$;
	private String day = Messages.getString("TimeAgo.DAY"); //$NON-NLS-1$
	private String days = Messages.getString("TimeAgo.DAYS"); //$NON-NLS-1$
	private String month = Messages.getString("TimeAgo.MONTH"); //$NON-NLS-1$
	private String months = Messages.getString("TimeAgo.MONTH"); //$NON-NLS-1$
	private String year = Messages.getString("TimeAgo.YEAR"); //$NON-NLS-1$
	private String years = Messages.getString("TimeAgo.YEARS"); //$NON-NLS-1$

	/**
	 * Get time until specified date
	 * 
	 * @param date
	 * @return time string
	 */
	public String timeUntil(Date date) {
		return timeUntil(date.getTime());
	}

	/**
	 * Get time ago that date occurred
	 * 
	 * @param date
	 * @return time string
	 */
	public String timeAgo(Date date) {
		return timeAgo(date.getTime());
	}

	/**
	 * Get time until specified milliseconds date
	 * 
	 * @param millis
	 * @return time string
	 */
	public String timeUntil(long millis) {
		return time(millis - System.currentTimeMillis(), true);
	}

	/**
	 * Get time ago that milliseconds date occurred
	 * 
	 * @param millis
	 * @return time string
	 */
	public String timeAgo(long millis) {
		return time(System.currentTimeMillis() - millis, false);
	}

	/**
	 * Get time string for milliseconds distance
	 * 
	 * @param distanceMillis
	 * @param allowFuture
	 * @return time string
	 */
	public String time(long distanceMillis, boolean allowFuture) {
		String time = null;

		String prefix = prefixAgo;
		String suffix = suffixAgo;

		if (allowFuture) {
			if (distanceMillis < 0) {
				prefix = prefixFromNow;
				suffix = suffixFromNow;
			}
			distanceMillis = Math.abs(distanceMillis);
		}

		double seconds = distanceMillis / 1000;
		double minutes = seconds / 60;
		double hours = minutes / 60;
		double days = hours / 24;
		double years = days / 365;

		if (seconds < 45)
			time = this.seconds;
		else if (seconds < 90)
			time = this.minute;
		else if (minutes < 45)
			time = MessageFormat.format(this.minutes, Math.round(minutes));
		else if (minutes < 90)
			time = this.hour;
		else if (hours < 24)
			time = MessageFormat.format(this.hours, Math.round(hours));
		else if (hours < 48)
			time = this.day;
		else if (days < 30)
			time = MessageFormat.format(this.days, Math.floor(days));
		else if (days < 60)
			time = this.month;
		else if (days < 365)
			time = MessageFormat.format(this.months, Math.floor(days / 30));
		else if (years < 2)
			time = this.year;
		else
			time = MessageFormat.format(this.years, Math.floor(years));

		return join(prefix, time, suffix);
	}

	/**
	 * Join time string with prefix and suffix. The prefix and suffix are only
	 * joined with the time if they are non-null and non-empty
	 * 
	 * @param prefix
	 * @param time
	 * @param suffix
	 * @return non-null joined string
	 */
	public String join(String prefix, String time, String suffix) {
		StringBuilder joined = new StringBuilder();
		if (prefix != null && prefix.length() > 0)
			joined.append(prefix).append(' ');
		joined.append(time);
		if (suffix != null && suffix.length() > 0)
			joined.append(' ').append(suffix);
		return joined.toString();
	}

	/**
	 * @return prefixAgo
	 */
	public String getPrefixAgo() {
		return prefixAgo;
	}

	/**
	 * @param prefixAgo
	 *            prefixAgo value
	 */
	public void setPrefixAgo(String prefixAgo) {
		this.prefixAgo = prefixAgo;
	}

	/**
	 * @return prefixFromNow
	 */
	public String getPrefixFromNow() {
		return prefixFromNow;
	}

	/**
	 * @param prefixFromNow
	 *            prefixFromNow value
	 */
	public void setPrefixFromNow(String prefixFromNow) {
		this.prefixFromNow = prefixFromNow;
	}

	/**
	 * @return suffixAgo
	 */
	public String getSuffixAgo() {
		return suffixAgo;
	}

	/**
	 * @param suffixAgo
	 *            suffixAgo value
	 */
	public void setSuffixAgo(String suffixAgo) {
		this.suffixAgo = suffixAgo;
	}

	/**
	 * @return suffixFromNow
	 */
	public String getSuffixFromNow() {
		return suffixFromNow;
	}

	/**
	 * @param suffixFromNow
	 *            suffixFromNow value
	 */
	public void setSuffixFromNow(String suffixFromNow) {
		this.suffixFromNow = suffixFromNow;
	}

	/**
	 * @return seconds
	 */
	public String getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds
	 *            seconds value
	 */
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	/**
	 * @return minute
	 */
	public String getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            minute value
	 */
	public void setMinute(String minute) {
		this.minute = minute;
	}

	/**
	 * @return minutes
	 */
	public String getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            minutes value
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            hour value
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @return hours
	 */
	public String getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            hours value
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * @return day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 *            day value
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * @param days
	 *            days value
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            month value
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return months
	 */
	public String getMonths() {
		return months;
	}

	/**
	 * @param months
	 *            months value
	 */
	public void setMonths(String months) {
		this.months = months;
	}

	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            year value
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return years
	 */
	public String getYears() {
		return years;
	}

	/**
	 * @param years
	 *            years value
	 */
	public void setYears(String years) {
		this.years = years;
	}
}
