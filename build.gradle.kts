plugins {
    id("java")
    application
}

group = "ru.apackage"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.javadoc {
    options.encoding = "UTF-8"

}

tasks.build {
    dependsOn(tasks.javadoc)
}

application {
    mainClass.set("ru.apackage.Main")
}