package marketplace.model
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TaskRepository {
    private val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low, LocalDateTime.now().minusDays(5).minusMinutes(15).toString()),
        Task("cleaning", "Clean the house", Priority.Low, LocalDateTime.now().minusDays(5).toString()),
        Task("gardening", "Mow the lawn", Priority.Medium, LocalDateTime.now().minusDays(103).toString()),
        Task("shopping", "Buy the groceries", Priority.High, LocalDateTime.now().minusDays(1000).toString()),
        Task("painting", "Paint the fence", Priority.Medium, LocalDateTime.now().minusDays(589).toString()),
        Task("cleaning", "Clean the house", Priority.Low, LocalDateTime.now().minusDays(1).toString()),
        Task("cleaning", "Clean the house", Priority.Low, LocalDateTime.now().minusDays(1).minusMinutes(13).toString()),
        Task("gardening", "Mow the lawn", Priority.Medium, LocalDateTime.now().minusDays(123).toString()),
        Task("shopping", "Buy the groceries", Priority.High, LocalDateTime.now().minusDays(1200).toString()),
        Task("painting", "Paint the fence", Priority.Medium, LocalDateTime.now().minusDays(9).toString()),
        Task("painting", "Paint the fence", Priority.Medium, LocalDateTime.now().minusDays(321).toString()),
        Task("painting", "Paint the fence", Priority.Medium, LocalDateTime.now().minusDays(13).toString()),
    )

    fun allTasks(): List<Task> = tasks

    fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    fun getRecentJobs(limit: Int): List<Task> {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        val mostRecentJobs = tasks
            .sortedByDescending { LocalDateTime.parse(it.createdAt, formatter) }
            .take(limit)
        return mostRecentJobs
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