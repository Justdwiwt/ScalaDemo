package leetCode._3100

object Solution_3069 {
  def resultArray(nums: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def f(first: List[Int], second: List[Int], ts: Array[Int]): List[Int] =
      if (ts.isEmpty) first.reverse ++ second.reverse
      else if (first.head > second.head) f(ts.head +: first, second, ts.tail)
      else f(first, ts.head +: second, ts.tail)

    f(List(nums.head), List(nums.tail.head), nums.tail.tail).toArray
  }
}
