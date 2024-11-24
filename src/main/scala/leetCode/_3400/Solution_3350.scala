package leetCode._3400

object Solution_3350 {
  def maxIncreasingSubarrays(nums: List[Int]): Int = {
    @scala.annotation.tailrec
    def f(arr: Array[Int], idx: Int, cnt: Int, preCnt: Int, res: Int): Int =
      if (idx >= arr.length) res
      else {
        val newCnt = cnt + 1
        if (idx == arr.length - 1 || arr(idx) >= arr(idx + 1)) {
          val newRes = res.max((newCnt / 2).max(preCnt.min(newCnt)))
          f(arr, idx + 1, 0, newCnt, newRes)
        } else f(arr, idx + 1, newCnt, preCnt, res)
      }

    f(nums.toArray, 0, 0, 0, 0)
  }
}
