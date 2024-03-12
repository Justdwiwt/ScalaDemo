package leetCode._2800

object Solution_2718 {
  def matrixSumQueries(n: Int, queries: Array[Array[Int]]): Long = {
    val row = Array.fill(n)(false)
    val col = Array.fill(n)(false)
    queries.:\(0L, 0, 0)((cur, acc) => {
      val ty = cur(0)
      val id = cur(1)
      val value = cur(2)
      if (ty == 0 && !row(id)) {
        row(id) = true
        (acc._1 + (n - acc._3) * value, acc._2 + 1, acc._3)
      } else if (ty == 1 && !col(id)) {
        col(id) = true
        (acc._1 + (n - acc._2) * value, acc._2, acc._3 + 1)
      } else acc
    })._1
  }
}
