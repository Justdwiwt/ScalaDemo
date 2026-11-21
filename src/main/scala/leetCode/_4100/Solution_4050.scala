package leetCode._4100

object Solution_4050 {
  private val MX = 100001

  private lazy val dp: Array[Int] = {
    val f = Array.fill(MX)(Int.MaxValue)
    f(0) = -1

    Iterator
      .iterate((1, 1)) { case (s, i) => (s + i + 1, i + 1) }
      .takeWhile { case (s, _) => s < MX }
      .foreach { case (s, i) =>
        (s until MX).foldLeft(f) { (arr, j) =>
          arr(j) = math.min(arr(j), arr(j - s) + i + 1)
          arr
        }
      }

    f
  }

  def minDays(n: Int): Int = dp(n)
}
