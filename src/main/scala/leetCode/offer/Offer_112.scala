package leetCode.offer

object Offer_112 {
  private val diff = Vector((0, 1), (0, -1), (1, 0), (-1, 0))

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    if (matrix.isEmpty) return 0
    val arr = Array.ofDim[Int](matrix.length, matrix.head.length)
    var res = 0
    matrix.indices.foreach(x => matrix.head.indices.foreach(y => res = res.max(dfs(x, y))))

    def dfs(x: Int, y: Int): Int =
      if (arr(x)(y) != 0) arr(x)(y)
      else {
        diff.foreach(d => {
          val (i, j) = (x + d._1, y + d._2)
          if (i < matrix.length && j < matrix.head.length && i >= 0 && j >= 0 && matrix(i)(j) > matrix(x)(y))
            arr(x)(y) = dfs(i, j).max(arr(x)(y))
        })
        arr(x)(y) += 1
        arr(x)(y)
      }

    res
  }
}
