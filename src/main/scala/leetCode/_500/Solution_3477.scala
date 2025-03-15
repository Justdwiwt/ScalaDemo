package leetCode._500

object Solution_3477 {
  def numOfUnplacedFruits(fruits: Array[Int], baskets: Array[Int]): Int =
    fruits.foldLeft(baskets.zipWithIndex)((acc, value) =>
        acc.find { case (v, _) => v >= value } match {
          case None => acc
          case Some((_, idx)) =>
            acc(idx) = (0, idx)
            acc
        })
      .count { case (v, _) => v > 0 }
}
