import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.jpa") version "1.9.23"
}

group = "aryumka"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
  //Spring AMQP
	implementation("org.springframework.boot:spring-boot-starter-amqp")
  testImplementation("org.springframework.amqp:spring-rabbit-test")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.linecorp.kotlin-jdsl:spring-data-jpa-support:3.3.1")
  implementation("com.linecorp.kotlin-jdsl:jpql-dsl:3.3.1")
  implementation("com.linecorp.kotlin-jdsl:jpql-render:3.3.1")
  runtimeOnly("com.h2database:h2")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")

	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

  //Axon Framework
  implementation(platform("org.axonframework:axon-bom:4.9.3")) // BOM 의존성 추가
  implementation("org.axonframework:axon-spring-boot-starter")
  testImplementation("org.axonframework:axon-test")

  /*테스트 또는 개발 관련*/
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(module = "mockito-core")
  }
  testImplementation ("io.kotest:kotest-runner-junit5:5.8.0")
  testImplementation ("io.kotest.extensions:kotest-extensions-spring:1.1.3")
  testImplementation("io.kotest:kotest-framework-datatest:5.8.0")
  testImplementation("io.mockk:mockk:1.13.4")
  testImplementation("com.ninja-squad:springmockk:4.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
