package leetCode._700

object Solution_633 {
  def judgeSquareSum(c: Int): Boolean = {
    (0 to math.sqrt(c).toInt).foreach(i => {
      val tmp: Double = math.sqrt(c - i * i)
      if (tmp - tmp.toInt == 0) return true
    })
    false
  }
}
