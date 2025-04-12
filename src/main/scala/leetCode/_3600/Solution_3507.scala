package leetCode._3600

object Solution_3507 {
  def minimumPairRemoval(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(nums: Array[Int], ops: Int): Int =
      if (nums.sorted.sameElements(nums)) ops
      else {
        val idx = nums.sliding(2).map(_.sum).zipWithIndex.minBy(_._1)._2
        val newNums = nums.take(idx) ++ Array(nums(idx) + nums(idx + 1)) ++ nums.drop(idx + 2)
        f(newNums, ops + 1)
      }

    f(nums, 0)
  }
}
