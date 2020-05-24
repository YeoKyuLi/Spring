# Spring: May.2020 ~ Jun.2020: External Project
This is my second project about back-end, the last one was that I was developed with Node.js the smart block back-end in SW Mastero in 2016.

The goal is studying Spring framework and back-end.



##### How to connect between local & git

```
git init
git remote add <http address>
```



##### How to connect between slack and git

After adding git app in slack 

```
/github signin
/github subscribe owner/repository
```



##### Goal from this project

- Spring Boot
- Gradle
- Java 1.8 or Higher
- NoSQL DB
- Spring Boot Test



##### Task break down

1. Project setting and run the Hello World
2. RESTful API
3. Client



##### Spec

1. JDK 1.4



##### Reference site

[RESTful history](https://www.martinfowler.com/articles/richardsonMaturityModel.html)





#### Task1. Setting Spring boot

1. Install JDK 1.2 or higher

<img src="/Users/yeokyuli/Library/Application Support/typora-user-images/image-20200524194807146.png" alt="image-20200524194807146" style="zoom:80%;" />

![image-20200524195238095](/Users/yeokyuli/Library/Application Support/typora-user-images/image-20200524195238095.png)  --> DB setting 





![image-20200524203100074](/Users/yeokyuli/Library/Application Support/typora-user-images/image-20200524203100074.png)





gradle setting

```
plugins {
    id 'org.springframework.boot' version '2.3.0.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
    id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springCloudVersion', "Hoxton.SR4")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
    testImplementation 'org.springframework.cloud:spring-cloud-starter-contract-stub-runner'
    testImplementation 'org.springframework.security:spring-security-test'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

test {
    useJUnitPlatform()
}
```



안되는 버전 --> DB 셋팅 들어가야됨

```
plugins {
    id 'org.springframework.boot' version '2.3.0.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
    id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springCloudVersion', "Hoxton.SR4")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
    testImplementation 'org.springframework.cloud:spring-cloud-starter-contract-stub-runner'
    testImplementation 'org.springframework.security:spring-security-test'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

test {
    useJUnitPlatform()
}

```



##### Error Reporting





http://localhost:8080/



#### Task2. Print Hello World Locally.

[Hello World](https://github.com/YeoKyuLi/Spring/blob/master/src/main/java/com/example/demo/web/WebController.java)

Result: http://localhost:8080/hello

