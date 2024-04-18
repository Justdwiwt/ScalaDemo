package leetCode._2600

object Solution_2599 {
  def makePrefSumNonNegative(nums: Array[Int]): Int = {
    var sum = 0L
    var res = 0
    val pq = new java.util.PriorityQueue[Int]

    nums.foreach(num => {
      if (num < 0) pq.offer(num)
      if (sum + num < 0) {
        sum -= pq.poll()
        res += 1
      }
      sum += num
    })

    res
  }
}
