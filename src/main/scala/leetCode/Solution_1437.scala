package leetCode

object Solution_1437 {
  def kLengthApart(nums: Array[Int], k: Int): Boolean = {
    @scala.annotation.tailrec
    def f(l: List[(Int, Int)]): Boolean = l match {
      case Nil => true
      case _ :: Nil => true
      case (_, i) :: (_, j) :: _ => if (j - i >= k + 1) f(l.tail) else false
    }

    f(nums.zipWithIndex.filter({ case (x, _) => x == 1 }).toList)
  }
}
