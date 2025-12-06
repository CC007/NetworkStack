plugins {
    id("buildsrc.convention.kotlin-jvm")
}

dependencies {
    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}

tasks.register<JavaExec>("server") {
    mainClass = "com.github.cc007.poc.network.TcpServerKt"
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register<JavaExec>("client") {
    mainClass = "com.github.cc007.poc.network.TcpClientKt"
    classpath = sourceSets["main"].runtimeClasspath
}