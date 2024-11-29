package leetCode._3400

object Solution_3363 {
  def maxCollectedFruits(fruits: Array[Array[Int]]): Int = {
    def dp(fruits: Array[Array[Int]]): Int = {
      val n = fruits.length
      val arr = Array.fill(n - 1, n + 1)(Int.MinValue)
      arr.head(n - 1) = fruits.head(n - 1)

      def updateDp(i: Int, j: Int): Int =
        Seq(arr(i - 1)(j - 1), arr(i - 1)(j), arr(i - 1)(j + 1)).max + fruits(i)(j)

      fruits.indices.drop(1).dropRight(1).foreach(i => ((i + 1).max(n - 1 - i) until n).foreach(j => arr(i)(j) = updateDp(i, j)))
      arr(n - 2)(n - 1)
    }

    fruits.zipWithIndex.map { case (row, i) => row(i) }.sum + dp(fruits) + dp(fruits.transpose)
  }
}
