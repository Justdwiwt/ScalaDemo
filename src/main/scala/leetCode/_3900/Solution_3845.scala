package leetCode._3900

object Solution_3845 {
  def maxXor(nums: Array[Int], k: Int): Int = {
    val n = nums.length

    val lefts = {
      val minQ, maxQ = new java.util.ArrayDeque[Int]()
      val res = Array.fill(n)(0)
      var left = 0

      nums.indices.foreach { right =>
        val x = nums(right)

        while (!minQ.isEmpty && x <= nums(minQ.peekLast())) minQ.pollLast()
        minQ.addLast(right)

        while (!maxQ.isEmpty && x >= nums(maxQ.peekLast())) maxQ.pollLast()
        maxQ.addLast(right)

        while (nums(maxQ.peekFirst()) - nums(minQ.peekFirst()) > k) {
          left += 1
          if (minQ.peekFirst() < left) minQ.pollFirst()
          if (maxQ.peekFirst() < left) maxQ.pollFirst()
        }

        res(right) = left
      }
      res
    }

    val pre = nums.scanLeft(0)(_ ^ _)

    val width =
      if (nums.max == 0) 0
      else 32 - Integer.numberOfLeadingZeros(nums.max)

    (width - 1 to 0 by -1).foldLeft(0) { (ans, i) =>
      val last = Array.fill(1 << (width - i))(-1)
      last(0) = 0

      val tryAns = (ans << 1) | 1

      val ok = nums.indices.exists { r =>
        val s = pre(r + 1) >> i
        val valid = last(tryAns ^ s) >= lefts(r)
        last(s) = r + 1
        valid
      }

      if (ok) tryAns else ans << 1
    }
  }
}
