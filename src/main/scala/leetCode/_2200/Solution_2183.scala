package leetCode._2200

object Solution_2183 {
  def countPairs(n: Array[Int], k: Int): Long = {
    var res = 0L
    val cnt = Array.fill(100001)(0)
    n.indices.foreach(i => if (n(i) % k == 0) {
      res += i
      cnt(0) += 1
    }
    else {
      val g = gcd(k, n(i))
      (0 until g).foreach(d => {
        val find = k / g * d
        res += cnt(find)
      })
      cnt(g) = cnt(g) + 1
    })
    res
  }

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
