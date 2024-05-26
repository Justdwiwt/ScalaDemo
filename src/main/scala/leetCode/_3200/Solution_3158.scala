package leetCode._3200

object Solution_3158 {
  def duplicateNumbersXOR(nums: Array[Int]): Int = {
    val initialState = (0, 0L)

    val (res, _) = nums.foldLeft(initialState) {
      case ((ans, vis), x) =>
        if ((vis >> x & 1) > 0) (ans ^ x, vis)
        else (ans, vis | 1L << x)
    }

    res
  }
}
