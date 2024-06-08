package leetCode._2500

object Solution_2430 {
  def deleteString(S: String): Int = {
    val s = S.toCharArray
    val n = s.length
    if (allEqual(s)) return n

    val lcp = Array.ofDim[Int](n + 1, n + 1)
    s.indices.reverse.foreach(i => (i + 1 until n).reverse.foreach(j => {
      if (s(i) == s(j)) lcp(i)(j) = lcp(i + 1)(j + 1) + 1
    }))

    val f = s.indices.reverse.foldLeft(Array.fill(n)(0))((f, i) => {
      (1 to (n - i) / 2).foreach(j => if (lcp(i)(i + j) >= j) f(i) = f(i).max(f(i + j)))
      f(i) += 1
      f
    })

    f(0)
  }

  private def allEqual(s: Array[Char]): Boolean =
    s.forall(_ == s.head)
}
