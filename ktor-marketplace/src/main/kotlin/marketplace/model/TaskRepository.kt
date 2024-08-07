package marketplace.model
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TaskRepository {
    private val jobs = mutableListOf(
        Job("cleaning", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().plusDays(1).toString(), LocalDateTime.now().toString()),
        Job("shopping", "Buy the groceries", "The list is here: ", LocalDateTime.now().plusDays(7).toString(), LocalDateTime.now().minusDays(5).toString()),
        Job("painting", "Paint the fence", "A color red", LocalDateTime.now().plusHours(4).toString(), LocalDateTime.now().minusDays(7).toString()),
        Job("cleaning2", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().minusDays(2).toString(), LocalDateTime.now().minusHours(2).toString()),
        Job("shopping2", "Buy the groceries", "The list is here: ", LocalDateTime.now().minusWeeks(1).toString(), LocalDateTime.now().minusDays(15).toString()),
        Job("painting2", "Paint the fence", "A color red", LocalDateTime.now().minusHours(1).toString(), LocalDateTime.now().minusDays(17).toString()),
        Job("cleaning3", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().plusMonths(1).toString(), LocalDateTime.now().minusHours(2).toString()),
        Job("shopping3", "Buy the groceries", "The list is here: ", LocalDateTime.now().plusDays(4).toString(), LocalDateTime.now().minusDays(10).toString()),
        Job("painting3", "Paint the fence", "A color red", LocalDateTime.now().minusWeeks(4).toString(), LocalDateTime.now().minusDays(11).toString()),
        Job("cleaning4", "Clean the house", "1. Make beds, 2. all rooms", LocalDateTime.now().minusYears(3).toString(), LocalDateTime.now().minusHours(15).toString()),
        Job("shopping4", "Buy the groceries", "The list is here: ", LocalDateTime.now().plusDays(2).toString(), LocalDateTime.now().minusWeeks(5).toString()),
        Job("painting4", "Paint the fence", "A color red", LocalDateTime.now().plusMonths(3).toString(), LocalDateTime.now().minusMinutes(24).toString()),
    )

    fun allJobs(): List<Job> = jobs

    fun getRecentJobs(limit: Int): List<Job> {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        val mostRecentJobs = jobs
            .sortedByDescending { LocalDateTime.parse(it.createdAt, formatter) }
            .take(limit)
        return mostRecentJobs
    }

    fun getActiveJobs(): List<Job> {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val now = LocalDateTime.now()
        val activeJobs = jobs
            .filter { LocalDateTime.parse(it.jobDateTime, formatter).isAfter(now) }
        return activeJobs
    }

//    fun taskByName(name: String) = tasks.find {
//        it.name.equals(name, ignoreCase = true)
//    }

//    fun addTask(task: Task) {
//        if (taskByName(task.name) != null) {
//            throw IllegalStateException("Cannot duplicate task names!")
//        }
//        tasks.add(task)
//    }
//
//    fun removeTask(name: String): Boolean {
//        return tasks.removeIf { it.name == name }
//    }
}