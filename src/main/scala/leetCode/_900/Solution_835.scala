package leetCode._900

object Solution_835 {
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    def f(img: Array[Array[Int]]): Seq[(Int, Int)] = img
      .indices
      .flatMap(r => img(r)
        .indices
        .withFilter(img(r)(_) == 1)
        .map((r, _)))

    f(A)
      .flatMap { case (x1, y1) => f(B).map { case (x2, y2) => (x2 - x1, y2 - y1) } }
      .groupBy(identity)
      .mapValues(_.length)
      .values
      .reduceOption(_.max(_))
      .getOrElse(0)
  }
}
