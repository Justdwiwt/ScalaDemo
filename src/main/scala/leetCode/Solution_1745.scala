package leetCode

object Solution_1745 {
  def checkPartitioning(s: String): Boolean =
    palindromePartition(s, 3) == 0

  def palindromePartition(s: String, k: Int): Int = {
    val cost = Array.fill(s.length, s.length)(0)
    (2 to s.length).foreach(span => (0 to s.length - span).foreach(i => {
      val j = i + span - 1
      cost(i)(j) = cost(i + 1)(j - 1) + (if (s(i) == s(j)) 0 else 1)
    }))
    val f = Array.fill(s.length + 1, k + 1)(Int.MaxValue)
    f(0)(0) = 0
    (1 to s.length).foreach(i => (1 to k.min(i)).foreach(j => {
      if (j == 1) f(i)(j) = cost(0)(i - 1)
      else (j - 1 until i).foreach(v => f(i)(j) = f(i)(j).min(f(v)(j - 1) + cost(v)(i - 1)))
    }))
    f(s.length)(k)
  }
}
