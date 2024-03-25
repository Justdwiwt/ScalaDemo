package leetCode._1600

object Solution_1526 {
  def minNumberOperations(target: Array[Int]): Int = {
    val l = target.toList
    l.zip(0 :: l)./:(0) { case (acc, (p, c)) => acc + 0.max(p - c) }
  }
}
