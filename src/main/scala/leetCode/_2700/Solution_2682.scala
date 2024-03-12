package leetCode._2700

object Solution_2682 {
  def circularGameLosers(n: Int, k: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(seen: Set[Int], i: Int, step: Int): Array[Int] =
      if (seen.contains(i)) (0 until n).filter(!seen.contains(_)).map(_ + 1).toArray
      else f(seen + i, (i + k * step) % n, step + 1)

    f(Set.empty, 0, 1)
  }
}
