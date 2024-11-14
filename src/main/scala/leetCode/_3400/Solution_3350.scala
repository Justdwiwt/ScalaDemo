package leetCode._3400

object Solution_3350 {
  def maxIncreasingSubarrays(nums: List[Int]): Int = {
    nums.zipWithIndex.foldLeft((0, 0, 0)) { case ((res, preCnt, cnt), (x, i)) =>
      val newCnt = cnt + 1
      val newAns = if (i == nums.length - 1 || x >= nums(i + 1)) {
        res.max((newCnt / 2).max(preCnt.min(newCnt)))
      } else res
      if (i == nums.length - 1 || x >= nums(i + 1)) (newAns, newCnt, 0)
      else (newAns, preCnt, newCnt)
    }._1
  }
}
