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
    implementation("com.sparkjava:spark-core:2.3")
    implementation("com.google.code.gson:gson:2.5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))

}

sourceSets{
    main{
        java.srcDirs("backend/src/main/java")
        resources.srcDirs("backend/src/main/resources")
    }
    test{
        java.srcDirs("backend/src/test/java")
        resources.srcDirs("backend/src/test/resources")
    }
}

tasks.test {
    useJUnitPlatform()
}