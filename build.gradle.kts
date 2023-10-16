import de.undercouch.gradle.tasks.download.Download


plugins {
	java
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	id("de.undercouch.download") version "5.3.0"
}

group = "twgl.com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

task<Download>("downloadNewrelic") {
	mkdir("newrelic")
    src("https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip")
    dest(file("newrelic"))
}

task<Copy>("unzipNewrelic") {
    from(zipTree(file("newrelic/newrelic-java.zip")))
    into(rootDir)
}