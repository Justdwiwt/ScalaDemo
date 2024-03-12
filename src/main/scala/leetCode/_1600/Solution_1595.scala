package leetCode._1600

object Solution_1595 {
  def connectTwoGroups(cost: List[List[Int]]): Int = {
    val m = cost.length
    val n = cost.head.length
    var rm = 0
    cost.head.indices.foreach(x => rm = rm | (1 << x))

    val tab = Array.ofDim[Int](m, n, rm + 1)

    def f(leftIdx: Int, rightIdx: Int, right: Int): Int = {
      if (leftIdx == m && right == rm) return 0
      if (rightIdx == n || leftIdx == m) return Integer.MAX_VALUE
      if (tab(leftIdx)(rightIdx)(right) == 0) {
        val a = f(leftIdx, rightIdx + 1, right | (1 << rightIdx))
        val b = f(leftIdx + 1, 0, right | (1 << rightIdx))
        tab(leftIdx)(rightIdx)(right) = f(leftIdx, rightIdx + 1, right)
        if (a != Integer.MAX_VALUE)
          tab(leftIdx)(rightIdx)(right) = tab(leftIdx)(rightIdx)(right).min(a + cost(leftIdx)(rightIdx))
        if (b != Integer.MAX_VALUE)
          tab(leftIdx)(rightIdx)(right) = tab(leftIdx)(rightIdx)(right).min(b + cost(leftIdx)(rightIdx))
      }
      tab(leftIdx)(rightIdx)(right)
    }

    f(0, 0, 0)
  }
}
