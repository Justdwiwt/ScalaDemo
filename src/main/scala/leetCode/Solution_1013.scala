package leetCode

object Solution_1013 {
  def canThreePartsEqualSum(A: Array[Int]): Boolean = {
    if (A.sum % 3 != 0) return false
    val s0 = A.sum / 3
    val s1 = 2 * s0
    val cum = Array.fill(A.length)(0)
    cum(0) = A(0)
    (1 until A.length).foreach(i => cum(i) = cum(i - 1) + A(i))
    val id1 = cum.zipWithIndex.filter(i => i._1 == s0).map(_._2)
    val id2 = cum.zipWithIndex.filter(i => i._1 == s1).map(_._2)
    if (id1.isEmpty || id2.isEmpty) false
    else id1.min < id2.max
  }
}
