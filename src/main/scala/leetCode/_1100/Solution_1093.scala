package leetCode._1100

object Solution_1093 {
  def sampleStats(counts: Array[Int]): Array[Double] = {
    @scala.annotation.tailrec
    def get(k: Int, i: Int = 0): Double = counts(i) match {
      case count if count > 0 && k < count => i.toDouble
      case count => get(k - count, i + 1)
    }

    val totalCount = counts.sum

    Array(counts.indexWhere(_ > 0),
      counts.lastIndexWhere(_ > 0),
      counts.indices.map(i => counts(i) * i.toDouble).sum / totalCount, totalCount % 2 match {
        case 0 =>
          val k = totalCount / 2
          (get(k - 1) + get(k)) / 2.0
        case _ => get(totalCount / 2)
      },
      counts.indices.maxBy(counts))
  }
}
