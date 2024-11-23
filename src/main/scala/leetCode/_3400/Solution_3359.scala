package leetCode._3400

object Solution_3359 {
  def countSubmatrices(grid: Array[Array[Int]], k: Int): Long = {
    val row = Array.fill(grid.length, grid.head.length)(0)

    grid.indices.foreach(i => grid.head.indices.foreach(j =>
      if (grid(i)(j) <= k)
        row(i)(j) = if (j > 0 && grid(i)(j - 1) >= grid(i)(j)) row(i)(j - 1) + 1 else 1
    ))

    var res = 0L

    grid.head.indices.foreach(j => {
      val st = scala.collection.mutable.Stack[(Int, Int)]()
      var total = 0L
      grid.indices.foreach(i => {
        var height = 1
        while (st.nonEmpty && st.top._1 > row(i)(j)) {
          val top = st.pop()
          total -= top._2 * (top._1 - row(i)(j))
          height += top._2
        }
        total += row(i)(j)
        res += total
        st.push((row(i)(j), height))
      })
    })
    res
  }
}
