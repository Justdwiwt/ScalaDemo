package leetCode

object Solution_2333 {
  def minSumSquareDiff(nums1: Array[Int], nums2: Array[Int], k1: Int, k2: Int): Long = {
    val numbers = nums1.zip(nums2)./:(Map.empty[Int, Int]) { case (m, (n1, n2)) =>
      val d = (n1 - n2).abs
      m.updated(d, m.getOrElse(d, 0) + 1)
    }

    numbers.toList.sortBy(-_._1) match {
      case Nil => ???
      case (v, cnt) :: tail => minimize(v, cnt, tail, k1 + k2)./:(0L) { case (sum, (v, c)) => sum + v.toLong * v * c }
    }
  }

  @scala.annotation.tailrec
  def minimize(value: Int, count: Int, list: List[(Int, Int)], operations: Int): List[(Int, Int)] =
    if (value == 0) (value, count) :: list
    else list match {
      case Nil =>
        if (count <= operations) minimize(value - 1, count, Nil, operations - count)
        else (value, count - operations) :: (value - 1, operations) :: Nil
      case (v, cnt) :: tail =>
        if (count <= operations && value - 1 == v) minimize(v, count + cnt, tail, operations - count)
        else if (count <= operations) minimize(value - 1, count, list, operations - count)
        else {
          val mid = if (value - 1 == v) List((v, cnt + operations)) else List((value - 1, operations), (v, cnt))
          (value, count - operations) :: mid ::: tail
        }
    }
}
