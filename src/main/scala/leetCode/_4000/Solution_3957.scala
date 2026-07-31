package leetCode._4000

object Solution_3957 {
  def maximumSum(nums: Array[Int], m: Int, l: Int, r: Int): Long = {
    val n = nums.length
    val pre = Array.fill[Long](n + 1)(0L)

    var i = 0
    while (i < n) {
      pre(i + 1) = pre(i) + nums(i)
      i += 1
    }

    def better(v1: Long, c1: Int, v2: Long, c2: Int): Boolean =
      v1 > v2 || (v1 == v2 && c1 > c2)


    def dpWithoutLimit(k: Long): (Long, Int) = {
      val dp = Array.fill[Long](n + 1)(0L)
      val cnt = Array.fill[Int](n + 1)(0)

      val deque = new Array[Int](n + 5)
      var head = 0
      var tail = 0

      var bestValue = Long.MinValue / 4
      var bestCnt = 0

      var i = l

      while (i <= n) {
        val idx = i - l
        val newValue = dp(idx) - pre(idx)
        val newCnt = cnt(idx)

        var flag = true
        while (tail > head && flag) {
          val last = deque(tail - 1)
          val lastValue = dp(last) - pre(last)
          val lastCnt = cnt(last)

          if (!better(lastValue, lastCnt, newValue, newCnt)) tail -= 1
          else flag = false
        }


        deque(tail) = idx
        tail += 1

        val j = deque(head)

        val chooseValue = dp(j) - pre(j) + pre(i) - k

        val chooseCnt = cnt(j) - 1

        if (better(chooseValue, chooseCnt, bestValue, bestCnt)) {
          bestValue = chooseValue
          bestCnt = chooseCnt
        }

        if (better(chooseValue, chooseCnt, dp(i - 1), cnt(i - 1))) {
          dp(i) = chooseValue
          cnt(i) = chooseCnt
        } else {
          dp(i) = dp(i - 1)
          cnt(i) = cnt(i - 1)
        }

        if (deque(head) <= i - r) head += 1

        i += 1
      }


      (bestValue, -bestCnt)
    }

    val first = dpWithoutLimit(0)

    if (first._2 <= m) first._1
    else {
      var sum = 0L
      nums.foreach(x => if (x > 0) sum += x)

      var left = 0L
      var right = sum + 1

      var ans = 0L

      while (left + 1 < right) {
        val mid = (left + right) / 2
        val res = dpWithoutLimit(mid)

        if (res._2 <= m) {
          ans = res._1 + mid * m
          right = mid
        } else left = mid
      }

      ans
    }
  }
}
