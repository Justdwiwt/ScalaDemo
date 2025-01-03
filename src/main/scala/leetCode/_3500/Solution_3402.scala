package leetCode._3500

object Solution_3402 {
  def minimumOperations(grid: Array[Array[Int]]): Int =
    grid.transpose.foldLeft(0)((totalOps, col) => {
      col.foldLeft((-1, totalOps)) { case ((pre, ops), x) =>
        val newOps = ops + 0.max(pre + 1 - x)
        val newPre = x.max(pre + 1)
        (newPre, newOps)
      }._2
    })
}
