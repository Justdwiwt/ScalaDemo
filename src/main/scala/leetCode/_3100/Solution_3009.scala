package leetCode._3100

object Solution_3009 {
  def maxIntersectionCount(y: Array[Int]): Int = {
    val n = y.length
    val doubledY = y.map(_ * 2)

    val d = y.indices.drop(1).foldLeft(collection.mutable.Map.empty[Int, Int].withDefaultValue(0))((acc, i) => {
      val l = doubledY(i).min(doubledY(i - 1))
      val r = doubledY(i).max(doubledY(i - 1))

      acc(l) += 1
      acc(r + 1) -= 1
      acc(doubledY(i)) -= 1
      acc(doubledY(i) + 1) += 1

      acc
    })

    d(doubledY(n - 1)) += 1
    d(doubledY(n - 1) + 1) -= 1

    d.toSeq.sortBy(_._1).foldLeft((0, 0)) { case ((s, res), (_, count)) =>
      val newSum = s + count
      (newSum, res.max(newSum))
    }._2
  }
}
