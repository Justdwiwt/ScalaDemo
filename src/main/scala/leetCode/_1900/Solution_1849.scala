package leetCode._1900

object Solution_1849 {
  def splitString(s: String): Boolean = {

    def f(s: String, i: BigInt): Boolean =
      if (s.isEmpty) true
      else s.inits.filter(_.nonEmpty).exists(h => BigInt(h) == i && f(s.drop(h.length), i - 1))

    s.indices.drop(1).exists(i => f(s.drop(i), BigInt(s.take(i)) - 1))

  }
}
