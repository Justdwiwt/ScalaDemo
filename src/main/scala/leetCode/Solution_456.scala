package leetCode

import scala.collection.mutable

object Solution_456 {
  def find132pattern(nums: Array[Int]): Boolean = {
    var MN = Int.MinValue
    val st = new mutable.Stack[Int]()
    (nums.length - 1 to 0 by -1).foreach(i => {
      if (nums(i) < MN) return true
      while (st.nonEmpty && nums(i) > st.top) {
        MN = st.top
        st.pop
      }
      st.push(nums(i))
    })
    false
  }
}
