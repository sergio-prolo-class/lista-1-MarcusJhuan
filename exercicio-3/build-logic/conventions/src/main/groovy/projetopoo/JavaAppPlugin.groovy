package projetopoo

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion

class JavaAppPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.pluginManager.apply('application')
        project.pluginManager.apply('java-library')

        project.repositories {
            mavenCentral()
        }

        project.dependencies {
            testImplementation 'junit:junit:4.13.2'
        }

        // Configuração da versão do Java
        project.java {
            toolchain {
                languageVersion = JavaLanguageVersion.of(17)
            }
        }

        project.application {
            mainClass = 'projetopoo.Main'
        }
    }
}