package leetCode._2600

object Solution_2510 {
  def isThereAPath(grid: Array[Array[Int]]): Boolean = {
    val m = grid.length
    val n = grid.head.length
    var arr: Array[BigInt] = Array.fill(n)(0)
    arr(0) = BigInt(1)

    if ((m + n) % 2 == 0) return false

    grid.foreach(g => {
      val tmp = arr
      arr = Array(arr.head << g.head)
      grid.head.indices.drop(1).foreach(i => arr :+= ((arr.last | tmp(i)) << g(i)))
    })

    ((BigInt(1) << ((m + n) / 2)) & arr.last) > 0
  }
}
