package leetCode

object Solution_514 {
  def findRotateSteps(ring: String, key: String): Int = {
    var dp = Array.fill[(Int, Int)](1)(0, 0)
    key.foreach(k => dp = ring.zipWithIndex.filter(_._1 == k).map({ case (_, i) => (dp.map(t => t._1 + (i - t._2).abs.min(ring.length - (i - t._2).abs) + 1).min, i) }).toArray)
    dp.minBy(_._1)._1
  }
}
