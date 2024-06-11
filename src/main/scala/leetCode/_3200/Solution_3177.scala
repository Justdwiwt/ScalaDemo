package leetCode._3200

object Solution_3177 {
  def maximumLength(nums: Array[Int], k: Int): Int = {
    val initialFs = Map[Int, Vector[Int]]().withDefaultValue(Vector.fill(k + 1)(0))
    val initialMx = Vector.fill(k + 2)(0)

    def updateStates(nums: Array[Int], fs: Map[Int, Vector[Int]], mx: Vector[Int]): Vector[Int] = nums
      .foldLeft((fs, mx)) { case ((fsAcc, mxAcc), x) =>
        val f = fsAcc(x)
        val updatedF = (k to 0 by -1).foldLeft(f)((fAcc, j) => fAcc.updated(j, fAcc(j).max(mxAcc(j)) + 1))
        val updatedMx = (k to 0 by -1).foldLeft(mxAcc)((mxAcc, j) => mxAcc.updated(j + 1, updatedF(j).max(mxAcc(j + 1))))
        (fsAcc.updated(x, updatedF), updatedMx)
      }
      ._2

    val finalMx = updateStates(nums, initialFs, initialMx)
    finalMx(k + 1)
  }
}
