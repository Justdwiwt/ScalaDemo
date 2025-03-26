package leetCode._3500

object Solution_3489 {
  def minZeroArray(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    if (nums.forall(_ == 0)) return 0

    val vec = nums.map(n => (0 to n).map(_ == 0).toVector).toVector
    val queryList = queries.toList.map(_.toList)

    @scala.annotation.tailrec
    def processQueries(f: Vector[Vector[Boolean]], q: List[List[Int]], k: Int): Int = q match {
      case Nil => -1
      case (l :: r :: v :: Nil) :: rest =>
        val updatedF = (l to r).foldLeft(f)((fAcc, i) =>
          (nums(i) to v by -1).foldLeft(fAcc)((fInner, j) =>
            fInner.updated(i, fInner(i).updated(j, fInner(i)(j) || fInner(i)(j - v)))))
        if (updatedF.forall(_.last)) k + 1
        else processQueries(updatedF, rest, k + 1)
      case _ => -1
    }

    processQueries(vec, queryList, 0)
  }
}
