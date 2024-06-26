import name.remal.gradle_plugins.lombok.LombokPlugin

plugins {
  `java-library`
  alias(libs.plugins.lombok) apply false
  alias(libs.plugins.versionCheck)
}

group = "org.whatever.db"

val jdkVersion: String = libs.versions.jdkVersion.get()

val rlibs = rootProject.libs

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}

subprojects {
  if (project.name != "website"){
    apply<JavaLibraryPlugin>()
//    apply<KotlinPluginWrapper>()
    apply<LombokPlugin>()

    dependencies {
      implementation(rlibs.jetbrainsAnnotation)
      testImplementation(enforcedPlatform(rlibs.junitBom))
      testImplementation(rlibs.junitEngine)
      testImplementation(rlibs.junitPerf)
      testImplementation(rlibs.junitJuiter)
      testImplementation(rlibs.junitApi)
      testImplementation(rlibs.dataFaker)
    }
    tasks.test {
      useJUnitPlatform()
    }

    java {
      sourceCompatibility = JavaVersion.toVersion(jdkVersion)
      targetCompatibility = JavaVersion.toVersion(jdkVersion)
    }

//    kotlin {
//      jvmToolchain(jdkVersion.toInt())
//    }
  }
}

subprojects { parent!!.path.takeIf { it != rootProject.path }?.let { evaluationDependsOn(it) } }