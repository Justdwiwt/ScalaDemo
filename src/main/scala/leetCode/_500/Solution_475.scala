package leetCode._500

object Solution_475 {
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    val sorted = heaters.sorted

    @scala.annotation.tailrec
    def f(h: Int, i: Int): Int =
      if (i < sorted.length - 1 && (sorted(i + 1) - h).abs <= (sorted(i) - h).abs) f(h, i + 1)
      else sorted(i)

    houses.sorted.foldLeft(0)((res, h) => res.max((f(h, 0) - h).abs))
  }
}
