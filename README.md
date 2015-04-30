#Java timeago library

This is a Java port of the [jquery-timeago](https://github.com/rmm5t/jquery-timeago) plug-in.  Please visit the [jquery-timeago](http://rmm5t.github.com/jquery-timeago/) project page to read more about fuzzy timestamps.

##Building

The timeago project contains a [Maven](http://maven.apache.org/) pom.xml file that builds a jar containing the TimeAgo class.

To build and run the included unit tests:

```$ mvn clean install```

##Usage

```java
TimeAgo time = new TimeAgo('en'); //For English text OR TimeAgo time = new TimeAgo('es' for Spanish text

long current = System.currentTimeMillis();
String minutes = time.timeAgo(current - (15 * 60 * 1000));	// returns "15 minutes ago"
String hours = time.timeUntil(current - (6 * 60 * 60 * 1000));	// returns "6 hours from now"
```

### Maven

This library is available from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7C%20a%3A%22timeago%22%20g%3A%22com.github.kevinsawicki%22).

```xml
<dependency>
  <groupId>com.github.kevinsawicki</groupId>
  <artifactId>timeago</artifactId>
  <version>1.0.1</version>
</dependency>
```

##Contribution

If you would like to contribute locale-specific properties files please fork this repository and open a pull request.

##Other

[MIT License](http://www.opensource.org/licenses/mit-license.html)
