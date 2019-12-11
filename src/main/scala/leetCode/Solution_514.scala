package leetCode

object Solution_514 {
  def findRotateSteps(ring: String, key: String): Int = {
    val dp = Array.fill(key.length + 1, ring.length)(0)
    (key.length - 1 to 0 by -1).foreach(i => (0 until ring.length).foreach(j => {
      dp(i)(j) = Int.MaxValue
      (0 until ring.length).foreach(k => if (ring(k) == key(i)) {
        val diff = (j - k).abs
        val step = diff.min(ring.length - diff)
        dp(i)(j) = dp(i)(j).min(step + dp(i + 1)(k))
      })
    }))
    dp(0)(0) + key.length
  }
}
