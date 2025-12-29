package leetCode._3700

object Solution_3679 {
  def minArrivalsToDiscard(arrivals: Array[Int], w: Int, m: Int): Int = {
    if (arrivals.isEmpty) return 0

    val maxV = arrivals.max
    val cnt = Array.fill(maxV + 1)(0)
    var ans = 0

    arrivals.indices.foreach(i => {
      if (i >= w) {
        val left = arrivals(i - w)
        if (left != 0) cnt(left) -= 1
      }

      val x = arrivals(i)
      if (cnt(x) == m) {
        arrivals(i) = 0
        ans += 1
      } else cnt(x) += 1
    })

    ans
  }
}
