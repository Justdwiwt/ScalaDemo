package leetCode._3000

//fixme: case 543/648 accuracy overflow
object Solution_2967 {
  def minimumCost(nums: Array[Int]): Long = {
    val sortedNums = nums.sorted.map(BigInt(_))
    val midIndex = sortedNums.length / 2
    val mid = sortedNums(midIndex)

    if (isPalindrome(mid)) cost(sortedNums, mid).toLong
    else {
      var l = mid - 1
      var r = mid + 1
      while (l > BigInt(1) && !isPalindrome(l)) l -= 1
      while (r < BigInt("1000000000") && !isPalindrome(r)) r += 1

      cost(sortedNums, if (l > 1 && r < BigInt("1000000000")) {
        if ((mid - l) < (r - mid)) l else r
      } else if (l > 1) l else r)
    }.toLong
  }

  private def cost(nums: Array[BigInt], tar: BigInt): BigInt =
    nums.map(a => (a - tar).abs).sum

  private def isPalindrome(x: BigInt): Boolean =
    if (x < 0) false
    else {
      val str = x.toString
      str == str.reverse
    }
}
