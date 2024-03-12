package leetCode._1400

object Solution_1326 {
  def minTaps(n: Int, ranges: Array[Int]): Int = {
    val arr = Array.fill(n + 1)(0)
    ranges.indices.foreach(i => {
      val left = 0.max(i - ranges(i))
      val right = n.min(i + ranges(i))
      arr(left) = arr(left).max(right - left)
    })
    var step = 0
    var end = 0
    var far = 0
    (0 until n).foreach(i => {
      if (i > far) return -1
      far = far.max(i + arr(i))
      if (i == end) {
        step += 1
        end = far
      }
    })
    if (far >= n) step else -1
  }
}
