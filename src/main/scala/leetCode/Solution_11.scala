package leetCode

object Solution_11 {
  def maxArea(height: Array[Int]): Int = {
    var area: Int = 0
    var r: Int = height.length - 1
    var l: Int = 0
    while (r > l) {
      area = math.max(area, math.min(height(l), height(r)) * (r - l))
      if (height(r) > height(l)) l = l + 1
      else r = r - 1
    }
    area
  }
}
