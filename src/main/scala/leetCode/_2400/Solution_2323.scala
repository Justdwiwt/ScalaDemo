package leetCode._2400

object Solution_2323 {
  def minimumTime(jobs: Array[Int], workers: Array[Int]): Int = {
    val sortedJobs = jobs.sorted
    val sortedWorkers = workers.sorted
    var res = 0
    jobs.indices.foreach(i => res = res.max((sortedJobs(i) + sortedWorkers(i) - 1) / sortedWorkers(i)))
    res
  }
}
