Java timeago library
=====
This is a Java port of the [jquery-timeago](https://github.com/rmm5t/jquery-timeago) plug-in.

Usage
=====
    TimeAgo time = new TimeAgo();
    String minutes = time.timeAgo(System.currentTimeMillis() - (15*60*1000)); // returns "15 minutes ago"
Contribution
=====
If you would like to contribute locale-specific properties files please fork this repository and open a pull request.

Other
=====
[MIT License](http://www.opensource.org/licenses/mit-license.html)