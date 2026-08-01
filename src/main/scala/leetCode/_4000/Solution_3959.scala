package leetCode._4000

object Solution_3959 {
  def checkGoodInteger(n: Int): Boolean = {
    val s = n.toString.map(_.asDigit)
    s.map(x => x * x).sum - s.sum >= 50
  }
}
