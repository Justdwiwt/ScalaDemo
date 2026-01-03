package leetCode._3700

object Solution_3695 {
  private final class UnionFind(n: Int) {
    private val fa = Array.tabulate(n)(identity)
    val odd: Array[Int] = Array.tabulate(n)(_ & 1)

    def find(x: Int): Int =
      if (fa(x) == x) x
      else {
        fa(x) = find(fa(x))
        fa(x)
      }

    def merge(x: Int, y: Int): Unit = {
      val fx = find(x)
      val fy = find(y)
      if (fx != fy) {
        fa(fx) = fy
        odd(fy) += odd(fx)
      }
    }
  }

  def maxAlternatingSum(nums: Array[Int], swaps: Array[Array[Int]]): Long = {
    val uf = new UnionFind(nums.length)

    swaps.foreach { case Array(x, y) => uf.merge(x, y) }

    nums.indices
      .groupBy(uf.find)
      .iterator
      .map { case (r, idxs) =>
        val k = uf.odd(r)

        idxs
          .map(nums)
          .sorted
          .iterator
          .zipWithIndex
          .foldLeft(0L) { case (s, (v, i)) => if (i < k) s - v else s + v }
      }
      .sum
  }
}
