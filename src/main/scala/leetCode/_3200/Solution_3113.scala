package leetCode._3200

import java.util

object Solution_3113 {
  def numberOfSubarrays(nums: Array[Int]): Long = {
    val n = nums.length
    val count = Array.ofDim[Int](n)
    val queue = new util.ArrayDeque[Int]()
    nums.indices.foreach(i => {
      val currentValue = nums(i)
      var previousIndex = -1
      while (!queue.isEmpty && currentValue > nums(queue.getLast)) {
        val pollIndex = queue.removeLast()
        if (previousIndex == -1) {
          count(pollIndex) = 1
          previousIndex = pollIndex
        } else {
          if (nums(pollIndex) == nums(previousIndex)) {
            count(pollIndex) = count(previousIndex) + 1
            previousIndex = pollIndex
          } else {
            count(pollIndex) = 1
            previousIndex = pollIndex
          }
        }
      }
      queue.addLast(i)
    })

    var idx = -1
    while (!queue.isEmpty) {
      val pollIndex = queue.removeLast()
      if (idx == -1) count(pollIndex) = 1
      else {
        if (nums(pollIndex) == nums(idx)) count(pollIndex) = count(idx) + 1
        else count(pollIndex) = 1
      }
      idx = pollIndex
    }

    nums.indices.foldLeft(0L)((acc, i) => acc + count(i))
  }
}
