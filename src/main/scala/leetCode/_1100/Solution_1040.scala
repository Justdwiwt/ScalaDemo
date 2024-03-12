package leetCode._1100

object Solution_1040 {
  def numMovesStonesII(stones: Array[Int]): Array[Int] = {
    val s = stones.sorted
    var low = s.length
    var start = 0
    val high = (s(s.length - 1) - s(1) - s.length + 2).max(s(s.length - 2) - s(0) - s.length + 2)
    s.indices.foreach(i => {
      while (s(i) - s(start) >= s.length) start += 1
      if (i - start + 1 == s.length - 1 && s(i) - s(start) == s.length - 2) low = low.min(2)
      else low = low.min(s.length - (i - start + 1))
    })
    Array(low, high)
  }
}
