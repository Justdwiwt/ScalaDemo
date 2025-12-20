package leetCode._3700

object Solution_3648 {
  def minSensors(n: Int, m: Int, k: Int): Int = {
    val size = k * 2 + 1
    ((n - 1) / size + 1) * ((m - 1) / size + 1)
  }
}
