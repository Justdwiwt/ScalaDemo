package leetCode._1000

object Solution_989 {
  def addToArrayForm(A: Array[Int], K: Int): List[Int] =
    (BigInt(A.toList.mkString("")) + K).toString.map(_.asDigit).toList
}
