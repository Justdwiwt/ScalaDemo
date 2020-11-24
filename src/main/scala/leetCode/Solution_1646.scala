package leetCode

object Solution_1646 {
  def getMaximumGenerated(n: Int): Int = {
    if (n <= 1) return n
    val arr = Array.fill(n + 1)(0)
    arr(1) = 1
    var res = 1
    (2 to n).foreach(i => {
      arr(i) = if (i % 2 == 0) arr(i / 2) else arr(i / 2) + arr(i / 2 + 1)
      res = res.max(arr(i))
    })
    res
  }
}
