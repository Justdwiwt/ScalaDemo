package leetCode._3600

object Solution_3577 {
  def countPermutations(complexity: Array[Int]): Int =
    if (complexity.slice(1, complexity.length).min <= complexity.head) 0
    else factorial(complexity.length - 1, 1).toInt

  @scala.annotation.tailrec
  private def factorial(n: Int, out: Long): Long =
    if (n == 1) out else factorial(n - 1, (out * n) % 1000000007)
}
