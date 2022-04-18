package leetCode

object Solution_2226 {
  def maximumCandies(candies: Array[Int], k: Long): Int = {
    def canAllocate(count: Int): Boolean =
      candies./:(0L)((kidsHappy, pile) => kidsHappy + pile / count) >= k

    @scala.annotation.tailrec
    def binarySearch(l: Int, r: Int): Int =
      if (l >= r) l
      else {
        val mid = (l + r + 1) / 2
        if (canAllocate(mid)) binarySearch(l = mid, r)
        else binarySearch(l, mid - 1)
      }

    binarySearch(l = 0, r = candies.max)
  }
}
