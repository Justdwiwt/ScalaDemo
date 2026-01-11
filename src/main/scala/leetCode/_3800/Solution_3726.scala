package leetCode._3800

object Solution_3726 {
  def removeZeros(n: Long): Long = n
    .toString
    .filter(_ != '0')
    .toLong
}
