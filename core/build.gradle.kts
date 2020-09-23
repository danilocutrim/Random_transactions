    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.10.3")
}
