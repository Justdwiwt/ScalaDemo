package leetCode._1000

object Solution_914 {
  def hasGroupsSizeX(deck: Array[Int]): Boolean = 2 <= deck.zipWithIndex.groupBy(_._1).map(_._2.length).reduce(gcd)

  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int = if (x == 0) y else gcd(y % x, x)
}
