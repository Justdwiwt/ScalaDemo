package leetCode._2000

object Solution_1924 {
  // fixme: case 85/92 accuracy overflow
  def outerTrees(trees: Array[Array[Int]]): Array[Double] = {
    var r = 0.0
    var centerX = trees.head.head.toDouble
    var centerY = trees.head(1).toDouble
    trees.indices.foreach(i => if (dis(trees(i).head, centerX, trees(i)(1), centerY) > r * r) {
      centerX = trees(i).head.toDouble
      centerY = trees(i)(1).toDouble
      r = 0
      (0 until i).foreach(j => if (dis(trees(j).head, centerX, trees(j)(1), centerY) > r * r) {
        centerX = (trees(i).head + trees(j).head) / 2.0
        centerY = (trees(i)(1) + trees(j)(1)) / 2.0
        r = math.sqrt(dis(trees(j).head, centerX, trees(j)(1), centerY))
        (0 until j).foreach(k => if (dis(trees(k).head, centerX, trees(k)(1), centerY) > r * r) {
          val tmp = getCircle(trees, i, j, k)
          centerX = tmp.head
          centerY = tmp(1)
          r = tmp(2)
        })
      })
    })
    Array(centerX, centerY, r)
  }

  private def dis(x1: Double, x2: Double, y1: Double, y2: Double): Double =
    (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)

  private def getCircle(trees: Array[Array[Int]], idx1: Int, idx2: Int, idx3: Int): Array[Double] = {
    val P1 = trees(idx1)(1) - trees(idx3)(1)
    val P2 = trees(idx1)(1) - trees(idx2)(1)
    val Q1 = trees(idx1).head - trees(idx3).head
    val Q2 = trees(idx1).head - trees(idx2).head
    val A = (trees(idx1).head * trees(idx1).head - trees(idx2).head * trees(idx2).head) + (trees(idx1)(1) * trees(idx1)(1) - trees(idx2)(1) * trees(idx2)(1))
    val B = (trees(idx1).head * trees(idx1).head - trees(idx3).head * trees(idx3).head) + (trees(idx1)(1) * trees(idx1)(1) - trees(idx3)(1) * trees(idx3)(1))
    val C = 2 * (trees(idx1).head - trees(idx2).head) * (trees(idx1)(1) - trees(idx3)(1)) - 2 * (trees(idx1).head - trees(idx3).head) * (trees(idx1)(1) - trees(idx2)(1))
    val x = (P1 * A - P2 * B) / C
    val y = (Q2 * B - Q1 * A) / C
    Array(x, y, math.sqrt(dis(trees(idx1).head, x, trees(idx1)(1), y)))
  }
}
