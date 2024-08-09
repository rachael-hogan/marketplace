package marketplace.com.plugins

import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import marketplace.model.Bid
import marketplace.model.Job
import marketplace.model.JobRepository

fun Application.configureRouting() {
    routing {
        staticResources("static", "static")

        //updated implementation
        route("/jobs") {
            get {
                // get all jobs
                val jobs = JobRepository.allJobs()
                call.respond(jobs)
            }

            get("/recent") {
//              // get all jobs
                val jobs = JobRepository.getRecentJobs(10)
                call.respond(jobs)
            }
            get("/active") {
                val jobs = JobRepository.getActiveJobs()
                call.respond(jobs)
            }

            post {
                try {
                    val job = call.receive<Job>()
                    val newJob = JobRepository.addJob(job)
                    call.respond(newJob)
                } catch (ex: IllegalStateException) {
                    call.respond(HttpStatusCode.BadRequest)
                } catch (ex: JsonConvertException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
        route("/bids") {
            post {
                try {
                    val bid = call.receive<Bid>()
                    val newJob = JobRepository.addBid("painting2", bid)
                    call.respond(newJob)
                } catch (ex: IllegalStateException) {
                    call.respond(HttpStatusCode.BadRequest)
                } catch (ex: JsonConvertException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}