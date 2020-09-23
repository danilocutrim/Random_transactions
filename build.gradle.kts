plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

repositories {
	jcenter()
	mavenCentral()
}

subprojects{
	group = "com.devback"
	version = "0.0.1-SNAPSHOT"
	apply(plugin = "kotlin")
	apply(plugin = "idea")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")


	repositories {
		jcenter()
		mavenCentral()
	}

	tasks.compileKotlin {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjvm-default=enable")
			allWarningsAsErrors = false
			jvmTarget = "1.8"
		}
	}
	tasks.withType<Test> {
		useJUnitPlatform()
	}
	tasks.withType<Jar> {
			enabled = true
	}
}

