package leetCode._1700

object Solution_1689 {
  def minPartitions(n: String): Int = {
    n.map(_.toInt - '0'.toInt).max
  }
}
