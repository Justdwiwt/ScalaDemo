package leetCode._900

object Solution_828 {
  def uniqueLetterString(S: String): Int = {
    var res = 0
    var cur = 0
    val M = 1e9 + 7
    val first = new Array[Int](26)
    val second = new Array[Int](26)
    (0 until S.length).foreach(i => {
      val c = S(i) - 'A'
      cur = cur + 1 + i - first(c) * 2 + second(c)
      res = (res + cur) % M.toInt
      second(c) = first(c)
      first(c) = i + 1
    })
    res
  }
}
