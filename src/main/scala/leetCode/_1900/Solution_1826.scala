package leetCode._1900

object Solution_1826 {
  def badSensor(sensor1: Array[Int], sensor2: Array[Int]): Int = {
    val n = sensor1.length
    var idx = 0
    while (idx < n && sensor1(idx) == sensor2(idx)) idx += 1
    if (idx >= n - 1) return -1
    var j = idx + 1
    while (j < n && sensor1(j - 1) == sensor2(j)) j += 1
    if (j < n) return 2
    j = idx + 1
    while (j < n && sensor2(j - 1) == sensor1(j)) j += 1
    if (j < n) 1 else -1
  }
}
