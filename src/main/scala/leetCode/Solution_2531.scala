package leetCode

object Solution_2531 {
  def isItPossible(word1: String, word2: String): Boolean = {
    val a = count(word1)
    val b = count(word2)

    val m = a.count(_ != 0)
    val n = b.count(_ != 0)

    (0 until 26).foreach(i => (0 until 26).foreach(j => if (a(i) > 0 && b(j) > 0) {
      a(i) -= 1
      b(j) -= 1
      var dm = if (a(i) == 0) -1 else 0
      var dn = if (b(j) == 0) -1 else 0

      if (a(j) == 0) dm += 1

      if (b(i) == 0) dn += 1

      if (m + dm == n + dn) return true

      a(i) += 1
      b(j) += 1
    }))

    false
  }

  private def count(s: String): Array[Int] = {
    val res = new Array[Int](26)
    s.foreach(c => res(c - 'a') += 1)
    res
  }

}
