package leetCode.offer

object Offer_39 {
  def majorityElement(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def find(i: Int, res: Int, count: Int): Int = {
      if (i == nums.length) res
      else if (nums(i) == res) find(i + 1, res, count + 1)
      else {
        val nCount = count - 1
        val nRes = if (nCount == 0) nums(i) else res
        find(i + 1, nRes, nCount.max(1))
      }
    }

    find(0, nums(0), 1)
  }
}
