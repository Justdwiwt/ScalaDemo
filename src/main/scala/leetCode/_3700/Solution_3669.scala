package leetCode._3700

object Solution_3669 {
  private val MX = 100001
  private val divisors: Array[Array[Int]] = {
    val buf = Array.fill(MX)(scala.collection.mutable.ArrayBuffer[Int]())
    var i = 1
    while (i < MX) {
      var j = i
      while (j < MX) {
        buf(j) += i
        j += i
      }
      i += 1
    }
    buf.map(_.toArray)
  }

  def minDifference(n: Int, k: Int): Array[Int] = {
    var best = Int.MaxValue
    var ans: Array[Int] = null

    def dfs(i: Int, x: Int, path: List[Int]): Unit =
      if (i == k - 1) {
        val diff = x - path.head
        if (diff < best) {
          best = diff
          ans = (path :+ x).toArray
        }
      } else {
        val head = path.headOption.getOrElse(0)
        val prev = path.lastOption.getOrElse(0)

        divisors(x)
          .iterator
          .takeWhile(d => d * d <= x && (i == 0 || d - head < best))
          .filter(d => i == 0 || d >= prev)
          .foreach(d => dfs(i + 1, x / d, path :+ d))
      }

    dfs(0, n, Nil)
    ans
  }
}
