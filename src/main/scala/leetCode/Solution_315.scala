package leetCode

import scala.collection.mutable.ListBuffer

object Solution_315 {
  def countSmaller(nums: Array[Int]): List[Int] = {
    var t = 0
    val res = ListBuffer.fill(nums.length)(0)
    (nums.length - 2 to 0 by -1).foreach(i => {
      t = 0
      (nums.length - 1 until i by -1).foreach(j => if (nums(j) < nums(i)) t += 1)
      res(i) = t
    })
    res.toList
  }
}
