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

- Spring Boot: 2.3.0
- Gradle
- Java 14
- NoSQL DB - Mongo DB
- Spring Boot Test
- OS: Mac



##### Task break down

1. Project setting and run the Hello World
2. RESTful API
3. Client



##### Spec

1. JDK 14



##### Reference site

[RESTful history](https://www.martinfowler.com/articles/richardsonMaturityModel.html)




## W1
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



## W2

#### Task1. Connect MongoDB





##### Reference

​	[Spring Boot Intergration Testing with Embedded MongoDB](https://www.baeldung.com/spring-boot-embedded-mongodb)

​	[Accessing MongoDB Data with Rest](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

   [DB](https://velopert.com/436)

##### install MongoDB



```
brew install mongodb
```



1. Downloaded below pack.

   https://www.mongodb.com/dr/fastdl.mongodb.org/osx/mongodb-macos-x86_64-4.2.7.tgz/download

2. PATH environment variable

   ```
   sudo cp /path/to/the/mongodb-directory/bin/* /usr/local/bin/
   sudo ln -s  /path/to/the/mongodb-directory/bin/* /usr/local/bin/
   sudo mkdir -p /usr/local/var/mongodb
   sudo mkdir -p /usr/local/var/log/mongodb
   whoami
   yeokyuli
   sudo chown yeokyuli /usr/local/var/mongodb
   sudo chown yeokyuli /usr/local/var/log/mongodb
   ```



​							Check the Mongod

![image-20200607140924954](/Users/yeokyuli/Library/Application Support/typora-user-images/image-20200607140924954.png)



#### What is MongoDB and How to use it

NoSQL: Not Only SQL. 관계형 DB가 아니므로, RDMS처럼 고정된 스키마 및 JOIN이 존재하지 않는다.

![ffff](https://velopert.com/wp-content/uploads/2016/02/ffff.png)

​		

```
mongod --dbpath /usr/local/var/mongodb --logpath /usr/local/var/log/mongodb/mongo.log --fork

ps aux | grep -v grep | grep mongod


mongo

- use admin: 데이터베이스 스위치 혹은 생성
- show dbs: 데이터 베이스 리스트 출력
- show users
- db: 현재 사용하고 있는 데이터베이스 출력
- db.stats(): 현재 사용하고 있는 데이터 베이스 출력
- db.dropDatabase() : db 삭제
- db.createCollection(“todo”,{capped:true, size:6142800, max:10000})
- db.book.insert({“name”:”abc”}) , single
- db.<dbName>.drop()
- db.dropUser()
- db.dropUser("admin")
- db.createUser(
  {
    user: "admin",
    pwd: "admin",
    roles: [ { "role" : "userAdminAnyDatabase", "db" : "admin" }, 
    { "role" : "dbAdminAnyDatabase", "db" : "admin" }, 
    { "role" : "readWriteAnyDatabase", "db" : "admin" } ]
  }
)
- db.auth("id", "passward")
- db.getUsers()
- db.book.insert({"name": "toTolists", "author": "admin"})
- db.createCollection("todo")
- show collections
- db.<collection name>.drop()
```

---> [Roles](https://docs.mongodb.com/manual/tutorial/manage-users-and-roles/)

##### Setting and Develop 

build.gradle

```
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
```

application.properties

```
spring.data.mongodb.uri=mongodb:://127.0.0.1:27017/MyDatabase
```




#### Task2. RESTful API


