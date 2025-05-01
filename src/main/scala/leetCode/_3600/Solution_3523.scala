package leetCode._3600

object Solution_3523 {
  def maximumPossibleSize(nums: Array[Int]): Int =
    nums.tail.foldLeft((1, nums.head)) {
      case ((count, prev), value) =>
        if (value >= prev) (count + 1, value)
        else (count, prev)
    }._1
}
