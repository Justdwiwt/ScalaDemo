package leetCode._3700

object Solution_3603 {
  def minCost(m: Int, n: Int, waitCost: Array[Array[Int]]): Long = {
    val initialF: Vector[Long] = Vector.fill(n + 1)(Long.MaxValue).updated(1, -waitCost.head.head.toLong)

    val finalF = waitCost.zipWithIndex.foldLeft(initialF) { case (f, (row, i)) =>
      row.zipWithIndex.foldLeft(f) { case (curF, (c, j)) =>
        val updatedValue = curF(j).min(curF(j + 1)) + c + (i + 1).toLong * (j + 1)
        curF.updated(j + 1, updatedValue)
      }
    }

    finalF(n) - waitCost.last.last
  }
}
