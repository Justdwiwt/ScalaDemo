package leetCode._1400

import scala.collection.mutable

object Solution_1335 {
  def minDifficulty(jobDifficulty: Array[Int], d: Int): Int = {
    val n = jobDifficulty.length
    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(job: Int, daysLeft: Int): Int = m.getOrElseUpdate((job, daysLeft),
      if (daysLeft == 1) jobDifficulty.slice(job, n).max
      else (job to n - daysLeft)
        .foldLeft(Int.MaxValue, 0) { case ((minDiff, prevMaxDiff), lastJobForCurrDay) =>
          val maxDiff = prevMaxDiff.max(jobDifficulty(lastJobForCurrDay))
          (minDiff.min(maxDiff + dfs(lastJobForCurrDay + 1, daysLeft - 1)), maxDiff)
        }
        ._1
    )

    if (n < d) -1 else dfs(0, d)
  }
}
