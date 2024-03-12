package leetCode._2100

object Solution_2012 {
  def sumOfBeauties(nums: Array[Int]): Int = {
    val (forward, _) = nums.indices.drop(1).dropRight(1)./:((List.empty[Int], nums(0))) {
      case ((acc, curMx), i) =>
        if (nums(i) > curMx) (2 :: acc, nums(i))
        else if (nums(i) > nums(i - 1)) (1 :: acc, curMx)
        else (0 :: acc, curMx)
    }
    val (_, sum, _) = nums.indices.drop(1).dropRight(1).:\((forward, 0, nums(nums.length - 1))) {
      case (i, (acc, curSum, curMn)) =>
        if (nums(i) < curMn) (acc.tail, curSum + 2.min(acc.head), nums(i))
        else if (nums(i) < nums(i + 1)) (acc.tail, curSum + 1.min(acc.head), curMn)
        else (acc.tail, curSum, curMn)
    }
    sum
  }
}
