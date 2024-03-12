package leetCode._2700

object Solution_2673 {
  def minIncrements(n: Int, cost: Array[Int]): Int = (n / 2 - 1 to 0 by -1)./:(0)((acc, i) => {
    val l = i * 2 + 1
    val r = i * 2 + 2
    cost(i) += cost(l).max(cost(r))
    acc + (cost(l) - cost(r)).abs
  })
}
