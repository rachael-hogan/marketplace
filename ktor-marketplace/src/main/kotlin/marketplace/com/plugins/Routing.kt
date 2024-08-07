package marketplace.com.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import marketplace.model.TaskRepository

fun Application.configureRouting() {
    routing {
        staticResources("static", "static")

        //updated implementation
        route("/tasks") {
            get {
                // get all jobs
                val jobs = TaskRepository.getRecentJobs(10)
                call.respond(jobs)
            }

            get("/recent") {
//                call.respond(recentJobs)
            }
            get("/active") {
                // call.response(activeJobs)
            }

            post {
//                try {
//                    val job = call.receive<Job>()
//                    JobRepository.addJob(job)
//                    call.respond(HttpStatusCode.NoContent)
//                } catch (ex: IllegalStateException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                } catch (ex: JsonConvertException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                }
            }
        }
    }
}