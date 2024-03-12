package leetCode._100

object Solution_66 {
  def plusOne(digits: Array[Int]): Array[Int] =
    if (digits.forall(_ == 0)) digits.init :+ 1
    else (BigInt(digits.mkString) + 1).toString.toArray.map(_ - '0')
}
