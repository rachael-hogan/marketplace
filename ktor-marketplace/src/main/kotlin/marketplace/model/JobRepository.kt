package marketplace.model
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object JobRepository {
    private val jobs = mockedData

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

    fun addJob(job: Job): Job {
        // TODO: Validation
        jobs.add(job)
        return job
    }

    fun closeBiddingIfExpired(job: Job) {
        // Parse the job's expiration date/time
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val jobExpirationTime = LocalDateTime.parse(job.jobDateTime, formatter)

        // Get the current date/time
        val currentTime = LocalDateTime.now()

        // Check if the job's expiration time has passed and if the job is not already closed
        if (currentTime.isAfter(jobExpirationTime) && !job.isClosed) {
            // Close the job for bidding
            job.isClosed = true

            // Assign the lowest bidder as the winner
            job.winner = job.bids.minByOrNull { it.bidAmount }

            println("Bidding closed for job: ${job.description}")
            job.winner?.let {
                println("The winner is ${it.bidderName} with a bid of ${it.bidAmount}")
            } ?: run {
                println("No bids were placed for this job.")
            }
        } else if (job.isClosed) {
            println("Bidding is already closed for job: ${job.description}")
        } else {
            println("Bidding is still open for job: ${job.description}")
        }
    }

    fun addBid(jobName: String, bid: Bid): List<Bid> {
        val job = jobs.find { it.description == jobName }
        job?.let {
            it.bids += bid
            println("Bid added: $bid")
            return it.bids
        } ?: run {
            println("Job not found: $jobName")
        }
        return emptyList()
    }

    fun getBids(jobName: String?): List<Bid> {
        val job = jobs.find { it.description == jobName }
        job?.let {
            return it.bids
        } ?: run {
            println("Job not found: $jobName")
        }
        return emptyList()
    }
}