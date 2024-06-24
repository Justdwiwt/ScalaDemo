package leetCode._3200

object Solution_3193 {
  def numberOfPermutations(n: Int, requirements: Array[Array[Int]]): Int = {
    val M = 1000000007
    val req = Array.fill(n)(-1)
    req(0) = 0
    var m = 0
    requirements.foreach(p => if (p(0) < n) {
      req(p.head) = p(1)
      m = m.max(p(1))
    })
    if (req.head > 0) return 0

    val arr = Array.fill(m + 1)(0)
    arr(0) = 1
    (1 until n).foreach(i => {
      val mx = if (req(i) < 0) m else req(i)
      val r = req(i - 1)
      if (r >= 0) {
        (0 until r).foreach(arr(_) = 0)
        (r + 1 to mx.min(i + r)).foreach(arr(_) = arr(r))
        (mx.min(i + r) + 1 to m).foreach(arr(_) = 0)
      } else {
        (1 to mx).foreach(j => arr(j) = (arr(j) + arr(j - 1)) % M)
        (mx until i by -1).foreach(j => if (j - i - 1 >= 0) arr(j) = (arr(j) - arr(j - i - 1) + M) % M)
      }
    })
    arr(req(n - 1))
  }
}
