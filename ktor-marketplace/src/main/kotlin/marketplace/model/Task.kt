package marketplace.model

import kotlinx.serialization.Serializable

@Serializable
enum class Priority {
    Low, Medium, High, Vital
}

@Serializable
data class Job(
    val name: String,
    val description: String,
    val requirements: String,
    val jobDateTime: String,
    val createdAt: String,
)