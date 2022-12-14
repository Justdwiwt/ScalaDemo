package leetCode

object Solution_1052 {
  def maxSatisfied(customers: Array[Int], grumpy: Array[Int], minutes: Int): Int = {
    val zipped = (customers :+ 0).zip(grumpy :+ 0)
    zipped
      .map(x => x._1 * (1 - x._2))
      .sum + zipped
      .take(minutes)
      .map(x => x._1 * x._2)
      .sum + zipped
      .sliding(zipped.length - minutes, minutes)
      .toArray
      .transpose
      .scanLeft(0) { case (cur, Array((oc, og), (nc, ng))) => cur + nc * ng - oc * og }
      .max
  }
}
