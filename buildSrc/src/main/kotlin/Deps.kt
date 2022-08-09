object Versions {
    const val detekt = "1.20.0"
    const val ktor = "2.0.3"
    const val jupiterVersion = "5.8.2"
}

object Libs {

    const val ktorServerCore = "io.ktor:ktor-server-core:${Versions.ktor}"

    object Test {
        const val logBack = "ch.qos.logback:logback-classic:1.3.0-alpha5"

        const val ktorServerTestHost = "io.ktor:ktor-server-test-host:${Versions.ktor}"

        const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.jupiterVersion}"
        const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.jupiterVersion}"
        const val jupiterRuntime = "org.junit.jupiter:junit-jupiter-engine:${Versions.jupiterVersion}"
    }
}