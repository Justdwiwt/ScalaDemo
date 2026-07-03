package leetCode._4000

object Solution_3933 {
  def countLocalMaximums(matrix: Array[Array[Int]]): Int = {
    val n = matrix.length
    val m = matrix.head.length

    val pos = Array.fill(201)(Vector.empty[(Int, Int)])

    matrix.indices.foreach(i => {
      matrix(i).indices.foreach(j => {
        val v = matrix(i)(j)
        pos(v) = pos(v) :+ (i, j)
      })
    })

    matrix.indices.flatMap(i => matrix(i)
      .indices
      .map { j => val x = matrix(i)(j); (j, x) }
      .withFilter { case (_, x) => x > 0 }
      .map { case (j, x) =>
        val r1 = 0.max(i - x)
        val r2 = (n - 1).min(i + x)
        val c1 = 0.max(j - x)
        val c2 = (m - 1).min(j + x)

        val hasLarger = ((x + 1) to 200).exists(pos(_).exists { case (r, c) =>
          r >= r1 && r <= r2 && c >= c1 && c <= c2 && !((r - i).abs == x && (c - j).abs == x)
        })

        !hasLarger
      }
    ).count(identity)
  }
}
