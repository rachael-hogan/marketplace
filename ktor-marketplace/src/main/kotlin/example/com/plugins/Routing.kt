package example.com.plugins

import com.example.model.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        staticResources("static", "static")

        get("/tasks") {
            call.respond(
                listOf(
                    Task("cleaning", "Clean the house", Priority.Low),
                    Task("gardening", "Mow the lawn", Priority.Medium),
                    Task("shopping", "Buy the groceries", Priority.High),
                    Task("painting", "Paint the fence", Priority.Medium)
                )
            )
        }
    }
}