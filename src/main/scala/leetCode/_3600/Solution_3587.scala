package leetCode._3600

object Solution_3587 {
  def minSwaps(nums: Array[Int]): Int = {
    val n = nums.length
    val pos1: Array[Int] = nums.indices.filter(nums(_) % 2 == 1).toArray

    def calc(start: Int): Int = {
      val targetIndices = (start until n by 2).toArray
      if (targetIndices.length != pos1.length) Int.MaxValue
      else pos1.zip(targetIndices).map { case (i, j) => (i - j).abs }.sum
    }

    val res = calc(0).min(calc(1))
    if (res == Int.MaxValue) -1 else res
  }
}
