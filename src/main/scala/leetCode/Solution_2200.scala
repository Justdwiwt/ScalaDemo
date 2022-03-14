package leetCode

import scala.collection.mutable

object Solution_2200 {
  def findKDistantIndices(nums: Array[Int], key: Int, k: Int): List[Int] = {
    val st = mutable.HashSet.empty[Int]
    var res = List.empty[Int]
    nums.indices.foreach(i => if (nums(i) == key) {
      val start = 0.max(i - k)
      val end = (nums.length - 1).min(i + k)
      (start to end).foreach(j => st += j)
    })
    st.foreach(res ::= _)
    res.sorted
  }
}
