package leetCode

object Solution_387 {
  def firstUniqChar(s: String): Int = {
    val res: Array[Int] = new Array[Int](26)
    for (i <- 0 until s.length)
      res(s(i) - 'a') += 1
    for (j <- 0 until s.length)
      if (res(s(j) - 'a') == 1) return j
    -1
  }
}
