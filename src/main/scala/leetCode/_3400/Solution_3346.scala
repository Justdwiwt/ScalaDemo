package leetCode._3400

object Solution_3346 {
  def maxFrequency(nums: Array[Int], k: Int, numOperations: Int): Int = {
    def lowerBound(x: Int, nums: Array[Int]): Int = {
      @scala.annotation.tailrec
      def search(l: Int, r: Int): Int =
        if (l > r) l
        else {
          val m = (l + r) / 2
          if (nums(m) >= x) search(l, m - 1)
          else search(m + 1, r)
        }

      search(0, nums.length - 1)
    }

    val freqMap = nums.groupBy(identity).mapValues(_.length)

    val sortedNums = nums.sorted

    sortedNums.foldLeft(0)((maxFreq, x) => {
      val l = lowerBound(x - k, sortedNums)
      val r = lowerBound(x + k + 1, sortedNums)
      val l2 = lowerBound(x, sortedNums)
      val r2 = lowerBound(x + k * 2 + 1, sortedNums)

      val option1 = numOperations.min(r - l - freqMap(x)) + freqMap(x)
      val option2 = numOperations.min(r2 - l2)

      maxFreq.max(option1.max(option2))
    })
  }
}
