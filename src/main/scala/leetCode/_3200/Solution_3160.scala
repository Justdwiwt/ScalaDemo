package leetCode._3200

object Solution_3160 {
  def queryResults(limit: Int, queries: Array[Array[Int]]): Array[Int] = {
    val initial = (Map.empty[Int, Int], Map.empty[Int, Int], Array.empty[Int])

    val (_, _, res) = queries.foldLeft(initial) {
      case ((color, cnt, ans), Array(x, y)) =>
        val prevColor = color.getOrElse(x, -1)
        val prevCount = cnt.getOrElse(prevColor, 0)

        val updatedColor = color.updated(x, y)
        val updatedCnt = {
          val newCount = cnt.getOrElse(y, 0) + 1
          val decrementCount = if (prevColor != -1 && prevColor != y) prevCount - 1 else prevCount
          cnt.updated(y, newCount).updated(prevColor, decrementCount)
        }

        val updatedAns = ans :+ updatedCnt.values.count(_ > 0)
        (updatedColor, updatedCnt, updatedAns)
    }

    res
  }
}
