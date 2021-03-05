package leetCode

object Solution_1471 {
  def getStrongest(arr: Array[Int], k: Int): Array[Int] = {
    val sorted = arr.sorted
    val t = sorted((arr.length - 1) / 2)

    @scala.annotation.tailrec
    def f(acc: Array[Int], k: Int, l: Int, r: Int): Array[Int] =
      if (k == 0) acc
      else if (t - sorted(l) > sorted(r) - t) f(acc :+ sorted(l), k - 1, l + 1, r)
      else f(acc :+ sorted(r), k - 1, l, r - 1)

    f(Array.empty, k, 0, arr.length - 1)
  }
}
