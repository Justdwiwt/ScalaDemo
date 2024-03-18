package leetCode._3100

object Solution_3070 {
  def countSubmatrices(grid: Array[Array[Int]], k: Int): Int = {
    grid.indices.foreach(i => {
      var sum = 0
      grid.head.indices.foreach(j => {
        sum += grid(i)(j)
        if (i == 0) grid(i)(j) = sum
        else grid(i)(j) = sum + grid(i - 1)(j)
      })
    })
    grid.flatten.count(_ <= k)
  }
}
