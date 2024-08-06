package marketplace.com
import io.ktor.server.application.*
import marketplace.com.plugins.configureCORS
import marketplace.com.plugins.configureRouting
import marketplace.com.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)

}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureCORS()
}
