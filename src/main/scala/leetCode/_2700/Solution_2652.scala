package leetCode._2700

object Solution_2652 {
  def sumOfMultiples(n: Int): Int =
    (1 to n).filter(x => Seq(3, 5, 7).exists(x % _ == 0)).sum
}
