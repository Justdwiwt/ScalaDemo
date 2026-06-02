package leetCode._3900

object Solution_3899 {
  def internalAngles(sides: Array[Int]): Array[Double] =
    if ((sides ++ sides).sliding(3, 1).take(3).forall(xs => xs(0) < xs(1) + xs(2)))
      (sides ++ sides)
        .toList
        .map(_.toDouble)
        .sliding(3, 1)
        .take(3)
        .toList
        .map {
          case List(a, b, c) => math.acos((a * a + b * b - c * c) / (2 * a * b)) * 180 / math.Pi
          case _ => ???
        }
        .sorted
        .toArray
    else Array()
}
