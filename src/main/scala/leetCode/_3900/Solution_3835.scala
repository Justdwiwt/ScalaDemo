package leetCode._3900

object Solution_3835 {
  def countSubarrays(nums: Array[Int], k: Long): Long = {
    val minQ = collection.mutable.ArrayBuffer.empty[Int]
    val maxQ = collection.mutable.ArrayBuffer.empty[Int]

    nums.indices.foldLeft((0, 0L)) {
      case ((left, ans), right) =>

        val x = nums(right)

        while (minQ.nonEmpty && x <= nums(minQ.last))
          minQ.remove(minQ.length - 1)
        minQ.append(right)

        while (maxQ.nonEmpty && x >= nums(maxQ.last))
          maxQ.remove(maxQ.length - 1)
        maxQ.append(right)

        @scala.annotation.tailrec
        def shrink(l: Int): Int = {
          if (
            minQ.nonEmpty &&
              maxQ.nonEmpty &&
              (nums(maxQ.head).toLong - nums(minQ.head).toLong) *
                (right - l + 1).toLong > k
          ) {
            val newLeft = l + 1
            if (minQ.nonEmpty && minQ.head < newLeft)
              minQ.remove(0)
            if (maxQ.nonEmpty && maxQ.head < newLeft)
              maxQ.remove(0)
            shrink(newLeft)
          } else l
        }

        val newLeft = shrink(left)

        (newLeft, ans + (right - newLeft + 1))
    }._2
  }
}
