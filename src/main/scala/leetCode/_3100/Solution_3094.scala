package leetCode._3100

object Solution_3094 {
  private def commonBits(num: Int): Int = ???

  def findNumber(): Int = {
    val res = (0 until 30).foldLeft((commonBits(0), 1, 0)) { case ((x, v, acc), _) =>
      val y = commonBits(v)
      val newAcc = if (x < y) acc + v else acc
      (y, v << 1, newAcc)
    }._3
    res
  }
}
