package leetCode._2600

object Solution_2528 {
  def maxPower(stations: Array[Int], r: Int, k: Int): Long = {
    val n = stations.length
    val sum = Array.ofDim[Long](n + 1)
    stations.indices.foreach(i => sum(i + 1) = sum(i) + stations(i))
    var mn = Long.MaxValue
    val power = Array.fill(n)(0L)
    stations.indices.foreach(i => {
      power(i) = sum(n.min(i + r + 1)) - sum(0.max(i - r))
      mn = mn.min(power(i))
    })

    var left = mn
    var right = mn + k + 1
    var found = false
    var i = 0
    while (left + 1 < right && !found) {
      val mid = left + (right - left) / 2
      if (check(mid, power, n, r, k)) left = mid
      else right = mid
      if (left + 1 == right) found = true
      i += 1
    }
    left
  }

  private def check(minPower: Long, power: Array[Long], n: Int, r: Int, k: Int): Boolean = {
    val diff = Array.fill(n + 1)(0L)
    var sumD = 0L
    var need = 0L
    var i = 0
    while (i < n) {
      sumD += diff(i)
      val m = minPower - power(i) - sumD
      if (m > 0) {
        need += m
        if (need > k) return false
        sumD += m
        if (i + r * 2 + 1 < n) diff(i + r * 2 + 1) -= m
      }
      i += 1
    }
    true
  }
}
