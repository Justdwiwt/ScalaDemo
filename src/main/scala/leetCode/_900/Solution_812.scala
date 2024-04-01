package leetCode._900

object Solution_812 {
  def largestTriangleArea(points: Array[Array[Int]]): Double = points
    .flatMap(i => points
      .flatMap(j => points
        .map(k => 0.5 * (i.head * j(1) + j.head * k(1) + k.head * i(1) - j.head * i(1) - k.head * j(1) - i.head * k(1)).abs)))
    .max
}
