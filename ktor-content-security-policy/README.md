# Ktor Content Security Policy Plugin

## Installation

Include following in your `build.gradle.kts`:

```kotlin
implementation("dev.forst", "ktor-content-security-policy", "1.0.0")
```

## Usage

Minimal usage:

```kotlin
/**
 * Minimal Ktor application using Content Security Policy.
 */
fun Application.minimalExample() {
    install(ContentSecurityPolicy) {
        skipWhen { call ->
            call.request.path().startsWith("/some-ignored-route")
        }
        policy(
            "default-src" to "'none'"
        )
    }
}
```

For details see [MinimalExampleApp.kt](src/test/kotlin/dev/forst/ktor/csp/MinimalExampleApp.kt) with this example
application and [TestMinimalExampleApp.kt](src/test/kotlin/dev/forst/ktor/csp/TestMinimalExampleApp.kt) which verifies
that this app works as expected.