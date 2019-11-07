package leetCode

object Solution_823 {
  private val M = (1e9 + 7).toInt

  def numFactoredBinaryTrees(A: Array[Int]): Int = {
    val dp = Array.fill(A.length)(1)

    def func(arr: Array[Int]): Unit = {
      arr.indices.foreach(i =>
        (0 until i).withFilter(j =>
          arr(i) % arr(j) == 0).foreach(j =>
          (0 until i).withFilter(k =>
            arr(k) * arr(j) == arr(i)).foreach(k =>
            dp(i) = ((dp(i) + BigInt(dp(k)) * BigInt(dp(j))) % M).toInt)
        ))
    }

    func(A.sorted)
    dp.foldLeft(0)((sum, x) => (sum + x) % M)
  }

}
