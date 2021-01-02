package leetCode

object Solution_26 {
  def removeDuplicates(nums: Array[Int]): Int =
    if (nums.isEmpty) 0
    else nums.drop(1)./:((1, nums.head))((tup, cur) => {
      if (cur == tup._2) (tup._1, cur)
      else {
        nums(tup._1) = cur
        (tup._1 + 1, cur)
      }
    })._1
}
