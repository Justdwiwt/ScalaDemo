package leetCode

object Solution_2078 {
  def maxDistance(colors: Array[Int]): Int = {
    var res = 0
    colors.indices.dropRight(1).foreach(i => (i + 1 until colors.length).withFilter(j => colors(i) != colors(j)).foreach(j => res = res.max(j - i)))
    res
  }
}
