package leetCode

object Solution_922 {
  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    A.filter(_ % 2 == 0).zip(A.filter(_ % 2 != 0))./:(Array[Int]()) { (x, y) => x :+ y._1 :+ y._2 }
  }
}
