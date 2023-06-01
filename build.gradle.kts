plugins {
    // Language Plugins
    `java-library`
    kotlin("jvm") version Plugins.KOTLIN

    id("me.xtrm.postprocessor.root") version "+"
}

group = Coordinates.GROUP
version = Coordinates.VERSION

repositories {
    mavenCentral()
}

dependencies {
    Dependencies.kotlinModules.forEach { module ->
        implementation("org.jetbrains.kotlin", "kotlin-$module", Dependencies.KOTLIN)
    }
}
