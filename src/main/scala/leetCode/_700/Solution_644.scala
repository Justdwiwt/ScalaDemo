package leetCode._700

object Solution_644 {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    var maxVal = Int.MinValue.toDouble
    var minVal = Int.MaxValue.toDouble
    nums.foreach(n => {
      maxVal = maxVal.max(n)
      minVal = minVal.min(n)
    })

    def check(mid: Double): Boolean = {
      var sum = 0.0
      var prev = 0.0
      var minSum = 0.0
      (0 until k).foreach(sum += nums(_) - mid)
      if (sum >= 0) return true
      var i = k
      while (i < nums.length) {
        sum += nums(i) - mid
        prev += nums(i - k) - mid
        minSum = prev.min(minSum)
        if (sum >= minSum) return true
        i += 1
      }
      false
    }

    var prevMid = maxVal
    var error = Int.MaxValue.toDouble
    while (error > 0.00001) {
      val mid = (maxVal + minVal) * 0.5
      if (check(mid)) minVal = mid
      else maxVal = mid
      error = (prevMid - mid).abs
      prevMid = mid
    }
    minVal
  }
}
