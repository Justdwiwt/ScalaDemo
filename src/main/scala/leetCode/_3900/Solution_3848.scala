package leetCode._3900

object Solution_3848 {
  def isDigitorialPermutation(n: Int): Boolean = {
    val sum = n.toString.split("").map(_.toInt).map(factorial).sum
    isValidPermutation(n, sum)
  }

  private def isValidPermutation(n: Int, sum: Int): Boolean =
    n.toString.sorted == sum.toString.sorted

  private def factorial(n: Int): Int =
    (1 to n).product
}
