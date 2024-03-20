package leetCode._2100

object Solution_2078 {
  def maxDistance(colors: Array[Int]): Int = colors
    .indices
    .flatMap(i => ((i + 1) until colors.length)
      .withFilter(colors(_) != colors(i))
      .map(_ - i))
    .max
}
