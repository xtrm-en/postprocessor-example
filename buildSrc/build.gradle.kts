plugins {
    `kotlin-dsl`

    // Postprocessor
    id("me.xtrm.postprocessor") version "+"
}

repositories {
    mavenCentral()

    // Koffee repository, not required but a very useful library
    maven("https://maven.hackery.site")
}

dependencies {
    implementation("codes.som.anthony", "koffee", "8.0.2")
}
