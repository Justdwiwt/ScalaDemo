package leetCode._3400

object Solution_3333 {
  def possibleStringCount(word: String, k: Int): Int = {
    val M = 1000000007
    val n = word.length

    if (n < k) return 0

    var list = List.empty[Int]
    var res = 1L
    var cnt = 1

    word.indices.drop(1).foreach(i => if (word(i) == word(i - 1)) cnt += 1
    else {
      if (list.length < k) list = list :+ cnt
      res = res * cnt % M
      cnt = 1
    })

    if (list.length < k) list = list :+ cnt
    res = res * cnt % M

    val m = list.length
    if (m >= k) return res.toInt

    val arr = Array.fill(k)(0L)
    arr(0) = 1L

    list.zipWithIndex.foreach { case (c, i) =>
      (1 until k).foreach(j => arr(j) = (arr(j) + arr(j - 1)) % M)
      ((k - 1) until i by -1).foreach(j => arr(j) = (arr(j - 1) - (if (j > c) arr(j - c - 1) else 0) + M) % M)
      arr(i) = 0
    }

    ((res - arr.drop(m).sum % M + M) % M).toInt
  }
}
