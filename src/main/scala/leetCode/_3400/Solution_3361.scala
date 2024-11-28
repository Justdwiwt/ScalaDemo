package leetCode._3400

object Solution_3361 {
  def shiftDistance(s: String, t: String, nextCost: Array[Int], previousCost: Array[Int]): Long = {
    s.indices.foldLeft(0L) { (sum, i) =>
      val (si, ti) = (s(i) - 'a', t(i) - 'a')
      val nDist = Math.floorMod(ti - si, 26)
      val pDist = Math.floorMod(si - ti, 26)
      val nC = (0 until nDist).foldLeft(0L)((s, i) => s + previousCost((si + i) % 26))
      val pC = (0 until pDist).foldLeft(0L)((s, i) => s + previousCost((ti + i + 1) % 26))
      sum + nC.min(pC)
    }
  }
}