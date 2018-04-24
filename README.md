# Simple Spring boot app with trace enabled (sleuth)

### Versions
* Springboot - 1.5.10.RELEASE
* Spring cloud - Edgware.SR3

# Prerequisite
* Run springboot-web - https://github.com/sabtharishi/springboot-web

# Endpoints
Simple endpoint exposed by this app will try to consume other service's endpoint which does not implement tracing

Default port of this app is **8080**

1. http://localhost:8080/subjects?exception=false will work fine. You will see simple massage saying "App2 returned English".
2.  http://localhost:8080/subjects?exception=true will make app2 throw exception. You will see simple massage saying "got exception"

# Sample logs generated when throwing exceptions
When each span is about to be closed, using Custom Span reporter, we pring the span tags to the logs.

```
2018-04-24 18:11:48.822  INFO [app1,5202214a410d4bf6,b675f386d967f5c9,true] 12320 --- [nio-8080-exec-6] com.example.demo.CustomSpanReporter      : Span tags: [ http.path=/v1/subjects ] [ http.url=http://localhost:8090/v1/subjects?exception=true ] [ http.method=GET ] [ http.host=localhost ] 
2018-04-24 18:11:48.825  INFO [app1,5202214a410d4bf6,5202214a410d4bf6,true] 12320 --- [nio-8080-exec-6] com.example.demo.CustomSpanReporter      : Span tags: [ mvc.controller.class=SubjectController ] [ http.status_code=200 ] [ mvc.controller.method=getSubjects ] [ http.path=/subjects ] [ http.url=http://localhost:8080/subjects?exception=true ] [ error=500 null ] [ http.method=GET ] [ http.host=localhost ] 

```
