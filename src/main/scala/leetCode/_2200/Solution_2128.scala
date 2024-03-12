package leetCode._2200

object Solution_2128 {
  def removeOnes(grid: Array[Array[Int]]): Boolean = {
    grid.indices.drop(1).foreach(i => grid.head.indices.drop(1).foreach(j =>
      if ((grid(i)(j) + grid.head(j)) % 2 != (grid(i).head + grid.head.head) % 2) return false
    ))
    true
  }
}
