package leetCode._2400

object Solution_2397 {
  def maximumRows(mat: Array[Array[Int]], cols: Int): Int = {
    val bitmasks = mat
      .indices
      .map(r => mat.head.indices./:(0)((mask, c) => if (mat(r)(c) == 0) mask else mask | (1 << c)))

    mat
      .head
      .indices
      .combinations(cols)
      .map(cols => {
        val mask = mat.head.indices.diff(cols)./:(0)((mask, c) => mask | (1 << c))
        bitmasks.count(m => (m & mask) == 0)
      })
      .max
  }
}
