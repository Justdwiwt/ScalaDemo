package leetCode

object Solution_1260 {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = {
    val res = Array.fill(grid.length, grid(0).length)(0)
    grid.indices.foreach(i => grid(0).indices.foreach(j => {
      val cur = (i * grid(0).length + j + k) % (grid.length * grid(0).length)
      res(cur / grid(0).length)(cur % grid(0).length) = grid(i)(j)
    }))
    var t = List[List[Int]]()
    res.foreach(i => t :+= i.toList)
    t
  }
}
