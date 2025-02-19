# Ktor OpenAPI Generator

Hosted on different
repository: [LukasForst/ktor-openapi-generator](https://github.com/LukasForst/ktor-openapi-generator/).

## Minimal example

```kotlin
/**
 * Minimal example of OpenAPI plugin for Ktor.
 */
fun Application.minimalExample() {
    // install OpenAPI plugin
    install(OpenAPIGen) {
        // this automatically servers Swagger UI on /swagger-ui
        serveSwaggerUi = true
        info {
            title = "Minimal Example API"
        }
    }
    // install JSON support
    install(ContentNegotiation) {
        jackson()
    }
    // add basic routes for openapi.json and redirect to UI
    routing {
        // serve openapi.json
        get("/openapi.json") {
            call.respond(this@routing.application.openAPIGen.api.serialize())
        }
        // and do redirect to make it easier to remember
        get("/swagger-ui") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.json", true)
        }
    }
    // and now example routing
    apiRouting {
        route("/example/{name}") {
            // SomeParams are parameters (query or path), SomeResponse is what the backend returns and SomeRequest
            // is what was passed in the body of the request
            post<SomeParams, SomeResponse, SomeRequest> { params, someRequest ->
                respond(SomeResponse(bar = "Hello ${params.name}! From body: ${someRequest.foo}."))
            }
        }
    }
}

data class SomeParams(@PathParam("who to say hello") val name: String)
data class SomeRequest(val foo: String)
data class SomeResponse(val bar: String)
```