package leetCode._3800

object Solution_3785 {
  def minSwaps(nums: Array[Int], forbidden: Array[Int]): Int = {
    val n = nums.length

    val total = (nums.iterator ++ forbidden.iterator).foldLeft(Map.empty[Int, Int]) {
      case (m, x) => m.updated(x, m.getOrElse(x, 0) + 1)
    }

    if (total.exists(_._2 > n)) return -1

    val same = nums
      .iterator
      .zip(forbidden.iterator)
      .foldLeft(Map.empty[Int, Int]) {
        case (m, (x, y)) if x == y => m.updated(x, m.getOrElse(x, 0) + 1)
        case (m, _) => m
      }

    val k = same.values.sum
    val mx = same.valuesIterator.reduceOption(_.max(_)).getOrElse(0)

    math.max((k + 1) / 2, mx)
  }
}
