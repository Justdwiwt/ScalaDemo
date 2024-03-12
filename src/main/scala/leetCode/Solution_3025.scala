package leetCode

object Solution_3025 {
  def numberOfPairs(points: Array[Array[Int]]): Int = {
    val heights = points.sortBy { case Array(x, y) => (x, -y) }.map(_.last)
    heights.indices.foldLeft(0)((res, i) => {
      (i + 1 until points.length).foldLeft(res)((res, j) => {
        if (heights(i) < heights(j)) res
        else if ((i + 1 until j).exists(k => heights(k) <= heights(i) && heights(k) >= heights(j))) res
        else res + 1
      })
    })
  }
}
