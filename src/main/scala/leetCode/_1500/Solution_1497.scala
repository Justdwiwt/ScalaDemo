package leetCode._1500

object Solution_1497 {
  def canArrange(arr: Array[Int], k: Int): Boolean = {
    lazy val m = arr
      .toList
      .map(n => ((n % k) + k) % k)
      .groupBy(i => i)
      .mapValues(_.size)

    m.forall { case (k1, v1) => if (k1 == 0) (v1 % 2) == 0 else m.get(k - k1).contains(v1) }
  }
}
