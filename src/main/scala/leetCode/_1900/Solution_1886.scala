package leetCode._1900

object Solution_1886 {
  def findRotation(mat: Array[Array[Int]], target: Array[Array[Int]]): Boolean = (1 to 3)
    .scanLeft(mat) { case (m, _) => m.transpose.reverse }
    .exists(_.flatten.sameElements(target.flatten))
}
