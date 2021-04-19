package leetCode

object Solution_1814 {
  def countNicePairs(nums: Array[Int]): Int = nums
    .indices
    ./:(0, scala.collection.mutable.HashMap[Int, Int]())((b, a) => {
      val c = nums(a).toString.reverse.toInt
      val res = (b._1 + b._2.getOrElse(nums(a) - c, 0)) % 1000000007
      b._2(nums(a) - c) = b._2.getOrElse(nums(a) - c, 0) + 1
      (res, b._2)
    })._1 % 1000000007
}
