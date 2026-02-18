package leetCode._3900

object Solution_3834 {
  def mergeAdjacent(nums: Array[Int]): List[Long] = nums.foldLeft(List.empty[Long]) { (stack, num) =>

    @scala.annotation.tailrec
    def merge(st: List[Long], x: Long): List[Long] = st match {
      case h :: t if h == x => merge(t, x * 2)
      case _ => x :: st
    }

    merge(stack, num.toLong)
  }.reverse
}
