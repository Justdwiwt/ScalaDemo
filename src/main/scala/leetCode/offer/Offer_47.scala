package leetCode.offer

object Offer_47 {
  def maxValue(grid: Array[Array[Int]]): Int = {
    (1 until grid(0).length).foreach(j => grid(0)(j) += grid(0)(j - 1))
    (1 until grid.length).foreach(i => grid(0).indices.foreach(j => {
      if (i == 0) grid(i)(j) += grid(i)(j - 1)
      else if (j == 0) grid(i)(j) += grid(i - 1)(j)
      else grid(i)(j) += grid(i)(j - 1).max(grid(i - 1)(j))
    }))
    grid(grid.length - 1)(grid(0).length - 1)
  }
}
