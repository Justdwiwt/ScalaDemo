package leetCode._500

object Solution_457 {
  def circularArrayLoop(nums: Array[Int]): Boolean = {

    def f(flag: Boolean, idx: Int): Int = {
      val direction = nums(idx) >= 0
      if (flag != direction) return -1
      var nextIdx = (idx + nums(idx)) % nums.length
      if (nextIdx < 0) nextIdx += nums.length
      if (nextIdx == idx) return -1
      nextIdx
    }

    nums.zipWithIndex.foreach({ case (num, i) =>
      val isForward = num >= 0
      var slow = i
      var fast = i
      do {
        slow = f(isForward, slow)
        fast = f(isForward, fast)
        if (fast != -1) fast = f(isForward, fast)
      } while (slow != -1 && fast != -1 && slow != fast)
      if (slow != -1 && slow == fast) return true
    })
    false
  }
}
