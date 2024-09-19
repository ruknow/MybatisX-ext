buildscript {
    repositories {
        mavenLocal()
        maven { url=uri("https://maven.aliyun.com/repository/public/") }
        mavenCentral()
        maven { url=uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") }
        maven { url=uri("https://maven.xillio.com/artifactory/libs-release/") }
        maven { url=uri("https://plugins.gradle.org/m2/") }
        maven { url=uri("https://dl.bintray.com/jetbrains/intellij-plugin-service") }
        maven { url=uri("https://dl.bintray.com/jetbrains/intellij-third-party-dependencies/") }
        maven { url=uri("https://oss.sonatype.org/content/repositories/releases/") }
    }
    dependencies {
        classpath("org.jetbrains.intellij.plugins:gradle-intellij-plugin:1.17.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    }
}

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.0"
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

// https://github.com/JetBrains/gradle-intellij-plugin/
// http://www.jetbrains.org/intellij/sdk/docs/tutorials/build_system/prerequisites.html
intellij {
    version.set("2024.1")

//    type="IC"  // 社区版
//    setPlugins(arrayOf("java")) //Bundled plugin dependencies
    type.set("IU") // 企业版
    plugins.set(listOf("java",
        "Kotlin",
        "platform-langInjection",
//        "IntelliLang",
        "Spring",
        "spring-boot-core",
        "DatabaseTools")) //Bundled plugin dependencies

    pluginName.set("MybatisX")
//    sandboxDirectory.set("${rootProject.rootDir}/idea-sandbox")

    updateSinceUntilBuild.set(false)
//    isDownloadSources.set(true)
}

//publishPlugin {
//    username = project.hasProperty("publishUsername") ? project.property("publishUsername") : ""
//    password = project.hasProperty("publishPassword") ? project.property("publishPassword") : ""
//}

// 各种版本去这里找
// https://www.jetbrains.com/intellij-repository/releases

group="com.baomidou.plugin.idea.mybatisx"
version="1.6.15"

repositories {
    mavenLocal()
    maven { url=uri("https://maven.aliyun.com/repository/public/") }
//    jcenter()
    mavenCentral()
}

dependencies {
    implementation("com.softwareloop:mybatis-generator-lombok-plugin:1.0")
    implementation("uk.com.robust-it:cloning:1.9.12")
    implementation("org.mybatis:mybatis:3.5.16")
    implementation("org.mybatis.generator:mybatis-generator-core:1.4.0")
    implementation("com.baomidou:mybatis-plus-annotation:3.5.5.10")
    implementation("org.freemarker:freemarker:2.3.32")
    implementation("com.itranswarp:compiler:1.0")
//    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("commons-lang:commons-lang:2.6")

//    testCompile("junit:junit:4.13.2")
//    testCompile("commons-io:commons-io:2.8.0")
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("241")
        untilBuild.set("244.*")
    }
}
