package leetCode._2700

object Solution_2652 {
  def sumOfMultiples(n: Int): Int =
    (1 to n).filter(x => x % 3 == 0 || x % 5 == 0 || x % 7 == 0).sum
}
