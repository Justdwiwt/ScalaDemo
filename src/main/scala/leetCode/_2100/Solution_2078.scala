package leetCode._2100

object Solution_2078 {
  def maxDistance(colors: Array[Int]): Int = colors
    .indices
    .flatMap(i => ((i + 1) until colors.length)
      .withFilter(j => colors(j) != colors(i))
      .map(j => j - i))
    .max
}
