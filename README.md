#Java 'TimeAgo' multilanguage library

This is a Java port of the [jquery-timeago](https://github.com/rmm5t/jquery-timeago) plug-in.  Please visit the [jquery-timeago](http://rmm5t.github.com/jquery-timeago/) project page to read more about fuzzy timestamps.

This library is forked from Kevin Sawicki's 'java-timeago' to support more than only one language. Feel free to fork it and add your own! 


##Importing into your project
###Maven
1. Add the repository
```xml
<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
</repository>
```
2. Add the dependency
```xml
<dependency>
	    <groupId>com.github.Kinnonii</groupId>
	    <artifactId>java-timeago</artifactId>
	    <version>timeago-1.1.3</version>
</dependency>
```
###Gradle
1. Add this to your build file (your app's module build.gradle if you're integrating it in Android with Android Studio)
```
repositories {
	    maven {
	        url "https://jitpack.io"
	    }
}
dependencies {
	        compile 'com.github.Kinnonii:java-timeago:timeago-1.1.3'
}
```

>If you're using Android Studio, the build.gradle file would be like this:
```
android {
    compileSdkVersion 22
    buildToolsVersion "21.1.2"
    defaultConfig {
        applicationId "com.example.app"
        minSdkVersion 15
        targetSdkVersion 22
        versionCode 1
        versionName "0.1"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    productFlavors {
    }
}
repositories {
    maven {
        url "https://jitpack.io"
    }
    //Other repositories... p.e. mavenCentral()
}
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile 'com.github.Kinnonii:java-timeago:1.1.2'
    //Other libraries...
}
```

##Currently in work
* Deutsch
* French

It supports English, Spanish and Italian at the time.

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
