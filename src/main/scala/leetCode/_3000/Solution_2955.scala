package leetCode._3000

object Solution_2955 {
  def sameEndSubstringCount(s: String, queries: Array[Array[Int]]): Array[Int] = {
    val arr = Array.ofDim[Int](26, s.length + 1)
    s.zipWithIndex.foreach { case (v, i) => (0 until 26).foreach(k => arr(k)(i + 1) = arr(k)(i) + (if (v - 'a' == k) 1 else 0)) }
    val res = queries.map { query =>
      val i = query.head
      val j = query(1)
      arr.map(lis => (lis(j + 1) - lis(i)) * (lis(j + 1) - lis(i) + 1) / 2).sum
    }
    res
  }
}
