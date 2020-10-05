package leetCode

object Solution_1335 {
  def minDifficulty(jobDifficulty: Array[Int], d: Int): Int = {
    if (jobDifficulty.length < d) return -1
    val dp = Array.fill(d, jobDifficulty.length)(Int.MaxValue)
    dp(0)(0) = jobDifficulty(0)
    (1 until jobDifficulty.length).foreach(i => dp(0)(i) = dp(0)(i - 1) max jobDifficulty(i))
    (1 until dp.length).foreach(date => (date until dp(date).length).foreach(job => {
      var mx = Int.MinValue
      (job to date by -1).foreach(i => {
        mx = mx.max(jobDifficulty(i))
        dp(date)(job) = dp(date)(job).min(dp(date - 1)(i - 1) + mx)
      })
    }))
    dp.last.last
  }
}
