package leetCode._1800

object Solution_1703 {
  def minMoves(nums: Array[Int], k: Int): Int = {
    val diff = nums.zipWithIndex.filter(_._1 == 1).map(_._2)
    val arr = Array.ofDim[Int](diff.length + 1)
    arr.indices.drop(1).foreach(i => arr(i) = arr(i - 1) + diff(i - 1))

    def sum(i: Int, j: Int): Int =
      arr(j + 1) - arr(i)

    val _k = k / 2

    if (k % 2 == 1) {
      val t = (0 to diff.length - k)
        .map(i => sum(i + _k + 1, i + k - 1) - sum(i, i + _k - 1))
        .min
      t - _k * (_k + 1)
    } else {
      val t = (0 to diff.length - k)
        .map(i => sum(i + _k + 1, i + k - 1) - sum(i + 1, i + _k - 1) + diff(i + _k) - diff(i))
        .min
      t - _k - (_k - 1) * _k
    }
  }
}
