package leetCode._2700

object Solution_2684 {
  def maxMoves(grid: Array[Array[Int]]): Int = {
    val arr = Array.fill(grid.length)(new Array[Int](grid.head.length))
    arr.head.indices.reverse.tail.foreach(j => {
      arr.indices.foreach(i => {
        def cond(rowIndex: Int): Boolean =
          grid.lift(rowIndex).exists(row => row(j + 1) > grid(i)(j))

        def updateMax(row: Int): Unit =
          arr(i)(j) = arr(i)(j).max(arr(row)(j + 1) + 1)

        List(i - 1, i, i + 1).filter(cond).foreach(updateMax)
      })
    })
    arr.map(_.head).max
  }
}
