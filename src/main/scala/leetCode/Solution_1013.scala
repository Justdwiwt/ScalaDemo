package leetCode

object Solution_1013 {
  def canThreePartsEqualSum(arr: Array[Int]): Boolean = {
    val totalSum = arr.sum
    val target = totalSum / 3

    @scala.annotation.tailrec
    def twoSum(leftSum: Int, rightSum: Int, idx: Int): Boolean =
      if (idx == arr.length - 1) false
      else (target == leftSum && leftSum == rightSum) || twoSum(leftSum + arr(idx + 1), rightSum - arr(idx + 1), idx + 1)

    @scala.annotation.tailrec
    def findStartIdx(acc: Int, idx: Int): Option[Int] =
      if (acc == target) Some(idx)
      else if (idx == arr.length - 1) None
      else findStartIdx(acc + arr(idx), idx + 1)

    if (totalSum % 3 != 0) false
    else findStartIdx(arr.head, 1).fold(false)(idx => twoSum(arr(idx), totalSum - (target + arr(idx)), idx))
  }
}
