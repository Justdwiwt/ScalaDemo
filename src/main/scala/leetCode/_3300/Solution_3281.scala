package leetCode._3300

object Solution_3281 {
  private def isPossible(nums: Array[BigInt], d: BigInt, mid: BigInt): Boolean = {
    var prev = nums.head
    nums.tail.forall(cur => {
      val min = prev + mid
      if (min > cur + d) false
      else {
        prev = min.max(cur)
        true
      }
    })
  }

  def maxPossibleScore(start: Array[Int], d: Int): Int = {
    val sorted = start.sorted.map(BigInt(_))

    var s = BigInt(0)
    var e = BigInt(Int.MaxValue)

    var res = BigInt(0)

    while (s <= e) {
      val mid = (s + e) / 2
      if (isPossible(sorted, d, mid)) {
        res = mid
        s = mid + 1
      } else e = mid - 1
    }
    res.toInt
  }
}
