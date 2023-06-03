plugins {
    // Language Plugins
    `java-library`
    kotlin("jvm") version Plugins.KOTLIN

    id("me.xtrm.postprocessor.root") version "+"

//    id("me.xtrm.postprocessor.example-plugin") version "+"
}

group = Coordinates.GROUP
version = Coordinates.VERSION

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    Dependencies.kotlinModules.forEach { module ->
        implementation("org.jetbrains.kotlin", "kotlin-$module", Dependencies.KOTLIN)
    }
    postprocessor("me.xtrm.postprocessor", "example-dependency", "+")
}

allprojects {
    apply(plugin = "java-library")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
}
