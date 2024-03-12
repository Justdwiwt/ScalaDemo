package leetCode._2300

object Solution_2216 {
  def minDeletion(nums: Array[Int]): Int = {
    def f: List[Int] => Int = {
      case Nil => 0
      case _ :: Nil => 1
      case x :: y :: xs => if (x == y) 1 + f(y :: xs) else f(xs)
    }

    f(nums.toList)
  }
}
