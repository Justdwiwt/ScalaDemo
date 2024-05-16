package leetCode._2400

object Solution_2307 {
  private var fathers: Array[Int] = _
  private var weights: Array[Double] = _

  def checkContradictions(equations: List[List[String]], values: Array[Double]): Boolean = {
    val var2idx = equations.flatten.distinct.zipWithIndex.toMap
    val varCount = var2idx.size

    fathers = (0 until varCount).toArray
    weights = Array.fill(varCount)(1.0)

    equations.zip(values).foldLeft(false) {
      case (hasContradiction, (q, value)) if !hasContradiction =>
        val idx1 = var2idx(q.head)
        val idx2 = var2idx(q(1))
        if (find(idx1) != find(idx2)) {
          union(idx1, idx2, value)
          false
        } else (query(idx1, idx2) - value).abs >= 1e-5
      case (hasContradiction, _) => hasContradiction
    }
  }

  private def find(x: Int): Int = {
    if (fathers(x) != x) {
      val f = find(fathers(x))
      weights(x) *= weights(fathers(x))
      fathers(x) = f
    }
    fathers(x)
  }

  private def union(x: Int, y: Int, v: Double): Unit = {
    val xRoot = find(x)
    val yRoot = find(y)
    if (xRoot != yRoot) {
      fathers(xRoot) = yRoot
      weights(xRoot) = v * weights(y) / weights(x)
    }
  }

  private def query(x: Int, y: Int): Double =
    weights(x) / weights(y)
}
