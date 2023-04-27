plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.sql2o:sql2o:1.6.0")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("junit:junit:4.13.1")
    implementation("com.h2database:h2:1.4.191")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))

}

sourceSets{
    main{
        java.srcDirs("backend/src/main/java")
        resources.srcDirs("AllLife/backend/src/main/resources")
    }
    test{
        java.srcDirs("backend/src/test/java")
    }
}

tasks.test {
    useJUnitPlatform()
}
