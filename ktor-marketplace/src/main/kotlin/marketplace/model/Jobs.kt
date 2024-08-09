package marketplace.model
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
enum class Priority {
    Low, Medium, High, Vital
}

@Serializable
data class Job(
    val category: String = "",
    val description: String,
    val requirements: String,
    val jobDateTime: String,
    val createdAt: String,
    var bids: List<Bid> = emptyList(),
    var isClosed: Boolean = false,
    var winner: Bid? = null
)

@Serializable
data class Bid(
    val bidderName: String,
    val bidAmount: Double,
    val bidTime: String
)

val mockedData = mutableListOf(
    Job(
        category = "cleaning",
        description = "Clean the house",
        requirements = "1. Make beds, 2. all rooms",
        jobDateTime = LocalDateTime.now().plusDays(1).toString(),
        createdAt = LocalDateTime.now().toString(),
        bids = listOf(
            Bid("Alice", 120.0, LocalDateTime.now().minusHours(1).toString()),
            Bid("Bob", 115.0, LocalDateTime.now().minusHours(2).toString())
        )
    ),
    Job(
        category = "shopping",
        description = "Buy the groceries",
        requirements = "The list is here:",
        jobDateTime = LocalDateTime.now().plusDays(7).toString(),
        createdAt = LocalDateTime.now().minusDays(5).toString(),
        bids = listOf(
            Bid("Charlie", 80.0, LocalDateTime.now().minusDays(1).toString()),
            Bid("Dave", 75.0, LocalDateTime.now().minusDays(2).toString())
        )
    ),
    Job(
        category = "painting",
        description = "Paint the fence",
        requirements = "A color red",
        jobDateTime = LocalDateTime.now().plusHours(4).toString(),
        createdAt = LocalDateTime.now().minusDays(7).toString(),
        bids = listOf(
            Bid("Eve", 150.0, LocalDateTime.now().minusHours(3).toString()),
            Bid("Frank", 140.0, LocalDateTime.now().minusHours(5).toString())
        )
    ),
    Job(
        category = "cleaning2",
        description = "Clean the house",
        requirements = "1. Make beds, 2. all rooms",
        jobDateTime = LocalDateTime.now().minusDays(2).toString(),
        createdAt = LocalDateTime.now().minusHours(2).toString(),
        bids = listOf(
            Bid("Grace", 110.0, LocalDateTime.now().minusDays(3).toString())
        )
    ),
    Job(
        category = "shopping2",
        description = "Buy the groceries",
        requirements = "The list is here:",
        jobDateTime = LocalDateTime.now().minusWeeks(1).toString(),
        createdAt = LocalDateTime.now().minusDays(15).toString(),
        bids = listOf(
            Bid("Hank", 95.0, LocalDateTime.now().minusWeeks(1).toString())
        )
    ),
    Job(
        category = "painting2",
        description = "Paint the fence",
        requirements = "A color red",
        jobDateTime = LocalDateTime.now().minusHours(1).toString(),
        createdAt = LocalDateTime.now().minusDays(17).toString(),
        bids = listOf(
            Bid("Ivy", 135.0, LocalDateTime.now().minusDays(4).toString())
        )
    ),
    // More jobs without bids can be added here as well
    Job("cleaning3", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().plusMonths(1).toString(), LocalDateTime.now().minusHours(2).toString()),
    Job("shopping3", "Buy the groceries", "The list is here:", LocalDateTime.now().plusDays(4).toString(), LocalDateTime.now().minusDays(10).toString()),
    Job("painting3", "Paint the fence", "A color red", LocalDateTime.now().minusWeeks(4).toString(), LocalDateTime.now().minusDays(11).toString()),
    Job("cleaning4", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().minusYears(3).toString(), LocalDateTime.now().minusHours(15).toString()),
    Job("shopping4", "Buy the groceries", "The list is here:", LocalDateTime.now().plusDays(2).toString(), LocalDateTime.now().minusWeeks(5).toString()),
    Job("painting4", "Paint the fence", "A color red", LocalDateTime.now().plusMonths(3).toString(), LocalDateTime.now().minusMinutes(24).toString())
)