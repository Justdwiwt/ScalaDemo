package leetCode._4100

object Solution_4007 {
  def maximumWidth(planks: Array[Int]): Int = {
    val cnt = planks.groupBy(identity).mapValues(_.length).toMap

    val cntPair = scala.collection.mutable.Map.empty[Int, Int].withDefaultValue(0)

    cnt.foreach { case (x, c) =>
      cntPair(x) += c
      cntPair(2 * x) += c / 2

      cnt.foreach { case (y, c2) => if (y > x) cntPair(x + y) += c.min(c2) }
    }

    cntPair.values.max
  }
}
