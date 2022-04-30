package leetCode

object Solution_1300 {
  def findBestValue(arr: Array[Int], target: Int): Int = {
    val sorted = arr.sorted
    var pre = 0
    arr.indices.foreach(i => {
      val k = arr.length - i
      val d = pre + sorted(i) * k - target
      if (d >= 0) return sorted(i) - (d + k / 2) / k
      pre += sorted(i)
    })
    sorted(arr.length - 1)
  }
}
