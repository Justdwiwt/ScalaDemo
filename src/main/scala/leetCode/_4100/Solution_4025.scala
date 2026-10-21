package leetCode._4100

object Solution_4025 {
  def minPenalty(period: Int, lights: Array[Int], arrivalTime: Array[Int]): Int = {
    val mx = lights.max
    arrivalTime.foldLeft(0) { (ans, t) =>
      val r = t % period
      if (r >= mx) ans.max(period - r) else ans
    }
  }
}
