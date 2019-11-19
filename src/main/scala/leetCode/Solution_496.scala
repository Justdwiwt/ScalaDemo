package leetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_496 {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val res = new ArrayBuffer[Int]()
    val st = new mutable.Stack[Int]()
    val m = new mutable.HashMap[Int, Int]()
    nums2.foreach(i => {
      while (st.nonEmpty && st.top < i) {
        m(st.top) = i
        st.pop
      }
      st.push(i)
    })
    nums1.foreach(i => res.append(if (m.contains(i)) m(i) else -1))
    res.toArray
  }
}
