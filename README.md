#Java timeago library

This is a Java port of the [jquery-timeago](https://github.com/rmm5t/jquery-timeago) plug-in.  Please visit the [jquery-timeago](http://rmm5t.github.com/jquery-timeago/) project page to read more about fuzzy timestamps.

This library is forked from Kevin Sawicki's 'java-timeago' to support more than only one language. Feel free to fork it and add your own! 

####Currently in work
* Deutsch
* French

It supports English, Spanish and Italian at the time.

##Importing the library
Use Jitpack.io ([check here](https://jitpack.io/#Kinnonii/java-timeago/timeago-1.1.3))

##Usage

```java
TimeAgo time = new TimeAgo('en'); //For English text.
//TimeAgo time = new TimeAgo('it'); //For Italian text.
//TimeAgo time = new TimeAgo('es'); //For Spanish text.


long current = System.currentTimeMillis();
String minutes = time.timeAgo(current - (15 * 60 * 1000));	// returns "15 minutes ago"
String hours = time.timeUntil(current - (6 * 60 * 60 * 1000));	// returns "6 hours from now"
```


##Contribution

If you would like to contribute locale-specific properties files please fork this repository and open a pull request.

##Other

[MIT License](http://www.opensource.org/licenses/mit-license.html)
