package leetCode._1700

object Solution_1692 {
  def waysToDistribute(n: Int, k: Int): Int = {
    val res = Array.ofDim[Long](n, k)

    (0 until n).foreach(res(_)(0) = 1)
    (1 until k).foreach(j => (j until n).foreach(i => res(i)(j) = (res(i - 1)(j) * (j + 1) + res(i - 1)(j - 1)) % 1000000007))

    res(n - 1)(k - 1).toInt
  }
}
