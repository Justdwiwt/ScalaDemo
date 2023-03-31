package leetCode

object Solution_2595 {
  def evenOddBit(n: Int): Array[Int] = {
    val map = n.toBinaryString.reverse.zipWithIndex.groupBy(_._2 % 2).mapValues(_.count(_._1 == '1'))
    Array(map.getOrElse(0, 0), map.getOrElse(1, 0))
  }
}
