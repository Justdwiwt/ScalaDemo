package leetCode._1900

object Solution_1886 {
  def findRotation(mat: Array[Array[Int]], target: Array[Array[Int]]): Boolean = (0 to 3)
    .scanLeft(mat)((m, _) => m.transpose.reverse)
    .exists(_.zip(target).forall { case (a, b) => a.sameElements(b) })
}
