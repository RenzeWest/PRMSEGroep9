plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.groep9"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // dependencies
    implementation("com.zaxxer:HikariCP:5.1.0")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")

    implementation("com.microsoft.sqlserver:mssql-jdbc:12.6.1.jre11")

    implementation("org.springframework.boot:spring-boot:3.2.4")
    implementation("org.springframework:spring-web:6.1.5")
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.2.4")

    // testing dependencies
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot:3.2.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {

    dependsOn("shadowJar")

    manifest {
        attributes(Pair("Main-Class", "com.groep9.moviemingleserver.MovieMingleServer"))
    }
}