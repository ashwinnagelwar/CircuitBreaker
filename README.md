First latest dependency-->
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
    </dependency>
    is used and tried but circuit breaker and Retry was not working
    then added following depencecy and removed first dependency, now both are working
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
	<!-- https://mvnrepository.com/artifact/io.github.resilience4j/resilience4j-spring-boot2 -->
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-spring-boot3</artifactId>
</dependency>
