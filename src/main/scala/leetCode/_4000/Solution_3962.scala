package leetCode._4000

object Solution_3962 {
  def maxSum(nums: Array[Int], k: Int): Long = {
    val n = nums.length

    if (k == 0 || n == 1) nums.tail.foldLeft((nums.head.toLong, nums.head.toLong)) {
      case ((cur, ans), x) =>
        val next = x.toLong.max(cur + x)
        (next, ans.max(next))
    }._2
    else if (nums.forall(_ <= 0)) nums.max.toLong
    else {
      val negCount = nums.count(_ < 0)
      val positiveSum = nums.filter(_ >= 0).map(_.toLong).sum

      if (negCount <= k) positiveSum
      else {
        val prefix = nums.scanLeft(0L)(_ + _)
        val dp = Array.fill(n, n)(0L)

        nums.indices.foreach(i => {
          val pq = collection.mutable.PriorityQueue.empty[Int]
          var sum = 0L

          (i until n).foreach(j => {
            if (nums(j) < 0) {
              if (pq.size < k) {
                pq.enqueue(nums(j))
                sum += nums(j)
              } else if (pq.head > nums(j)) {
                sum -= pq.dequeue()
                pq.enqueue(nums(j))
                sum += nums(j)
              }
            } else dp(i)(j) = sum
          })
        })

        nums.indices.foldLeft(Long.MinValue)((answer, i) => {
          implicit val ordering: Ordering[Int] = Ordering.Int.reverse

          val pq = collection.mutable.PriorityQueue.empty[Int]
          var extra = 0L

          (0 until i).foreach(j => {
            if (nums(j) >= 0) {
              if (pq.size < k) {
                pq.enqueue(nums(j))
                extra += nums(j)
              } else if (pq.head < nums(j)) {
                extra -= pq.dequeue()
                pq.enqueue(nums(j))
                extra += nums(j)
              }
            }
          })

          (i + 1 until n).reverse.foldLeft(answer)((ans, j) => {
            val subSum = prefix(j + 1) - prefix(i) - dp(i)(j) + extra
            val nextAns = ans.max(subSum)

            if (nums(j) >= 0) {
              if (pq.size < k) {
                pq.enqueue(nums(j))
                extra += nums(j)
              } else if (pq.head < nums(j)) {
                extra -= pq.dequeue()
                pq.enqueue(nums(j))
                extra += nums(j)
              }
            }

            nextAns.max(extra)
          })
        })
      }
    }
  }
}
