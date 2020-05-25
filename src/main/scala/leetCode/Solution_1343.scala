package leetCode

object Solution_1343 {
  def numOfSubarrays(arr: Array[Int], k: Int, threshold: Int): Int = {
    var res = 0
    var sum = 0
    (0 until k).foreach(i => sum += arr(i))
    if (sum >= threshold * k) res += 1
    (0 until arr.length - k).foreach(i => {
      sum -= arr(i)
      sum += arr(k + i)
      if (sum >= threshold * k) res += 1
    })
    res
  }
}
