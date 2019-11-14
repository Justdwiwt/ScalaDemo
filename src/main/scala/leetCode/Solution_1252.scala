package leetCode

object Solution_1252 {
  def oddCells(n: Int, m: Int, indices: Array[Array[Int]]): Int = {
    var res = 0
    val row = Array.fill(n)(false)
    val col = Array.fill(m)(false)
    indices.foreach(i => {
      row(i(0)) = !row(i(0))
      col(i(1)) = !col(i(1))
    })
    (0 until n).foreach(i => (0 until m).foreach(j => if (row(i) ^ col(j)) res += 1 else res))
    res
  }
}
