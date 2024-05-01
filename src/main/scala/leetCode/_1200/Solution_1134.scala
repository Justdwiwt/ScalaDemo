package leetCode._1200

object Solution_1134 {
  def isArmstrong(N: Int): Boolean = {
    val n = N.toString.length
    val sum = N.toString.map(_.asDigit).map(math.pow(_, n).toInt).sum
    sum == N
  }
}
