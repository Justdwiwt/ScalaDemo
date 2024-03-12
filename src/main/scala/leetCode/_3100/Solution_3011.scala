package leetCode._3100

object Solution_3011 {
  def canSortArray(nums: Array[Int]): Boolean = {
    val res = nums.zip(nums.map(_.toBinaryString).map(_.count(_ == '1')))

    @scala.annotation.tailrec
    def f(next: Array[(Int, Int)], i: Int, temp: List[Int], res: List[Int]): List[Int] =
      if (next.isEmpty) res ++ temp.sorted
      else if (next.head._2 == i) f(next.tail, i, next.head._1 +: temp, res)
      else f(next, next.head._2, Nil, res ++ temp.sorted)

    f(res, 0, Nil, Nil).equals(nums.toList.sorted)
  }
}
