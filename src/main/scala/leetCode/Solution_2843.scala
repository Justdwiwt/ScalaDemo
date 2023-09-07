package leetCode

object Solution_2843 {
  def countSymmetricIntegers(low: Int, high: Int): Int = {
    var res = 0
    (low to high).foreach(i => {
      val s = i.toString
      var t = 0
      (0 until s.length / 2).foreach(j => t += s(j) - s(s.length - j - 1))
      if (s.length % 2 == 0 && t == 0) res += 1
    })
    res
  }
}
