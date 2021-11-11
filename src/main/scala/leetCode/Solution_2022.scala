package leetCode

object Solution_2022 {
  def construct2DArray(original: Array[Int], m: Int, n: Int): Array[Array[Int]] =
    if (m * n != original.length) Array.empty
    else Array.tabulate(m, n)((x, y) => original(x * n + y))
}
