package leetCode._3400

object Solution_3340 {
  def isBalanced(num: String): Boolean = {
    val (evens, odds) = num.map(_.asDigit).zipWithIndex.partition(_._2 % 2 == 0)
    evens.map(_._1).sum == odds.map(_._1).sum
  }
}
