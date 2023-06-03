plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version Plugins.KOTLIN
    `java-gradle-plugin`
    `maven-publish`
}

group = "me.xtrm.postprocessor"
version = "0.0.1-SNAPSHOT"

base {
    archivesName.set("example-plugin")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    mavenLocal()
}

dependencies {
    api("me.xtrm", "postprocessor", "0.3.0")
}

gradlePlugin {
    plugins {
        create("postprocessor-example") {
            id = "me.xtrm.postprocessor.example-plugin"
            implementationClass = "me.xtrm.gradle.postprocessor.test.TestPostProcessorPlugin"
        }
    }
}

java {
    withJavadocJar()
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

publishing {
    publications {
        create<MavenPublication>("example") {
            from(components["java"])
            this.artifactId = "example-dependency"
        }
    }
}
