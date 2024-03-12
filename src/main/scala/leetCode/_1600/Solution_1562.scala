package leetCode._1600

object Solution_1562 {
  def f(arr: Array[Int], idx: Int, m: Int): Boolean = {
    arr(idx) = 0
    ((idx - 1 to 0 by -1).takeWhile(i =>
      arr(i) == 1 && idx - i <= m + 2).size == m) ||
      ((idx + 1 until arr.length).takeWhile(i =>
        arr(i) == 1 && i - idx <= m + 2).size == m)
  }

  def findLatestStep(arr: Array[Int], m: Int): Int = {
    if (m == arr.length) m
    else {
      val A = Array.fill[Int](arr.length)(1)
      arr.indices.drop(1).reverse.find(idx => f(A, arr(idx) - 1, m)).getOrElse(-1)
    }
  }
}
