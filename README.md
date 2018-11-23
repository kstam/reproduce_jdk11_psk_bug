# JDK 11: Reproduce PSK issue

## Test

To build the 2 docker images run:
```
./build.sh
```

For JDK11 with TLS1.3 Run
```
./run_tls3.sh
```

For JDK11 without TLS1.3 Run
```
./run_no_tls3.sh
```

## Solution

Adding

```
-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2
```

to the java process when we are booting the app in the base image will solve the problem.

## JDK Issue link

https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8213202

## Inspiration from

https://gist.github.com/rraptorr/e9c20fbdac6cd5dea8481283bb058d15