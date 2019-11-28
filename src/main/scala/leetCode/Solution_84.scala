package leetCode

import scala.collection.mutable

object Solution_84 {
  def largestRectangleArea(heights: Array[Int]): Int = {
    var res = 0
    val st = new mutable.Stack[Int]()
    var h = heights
    h :+= 0
    h.indices.foreach(i => {
      while (st.nonEmpty && h(st.top) >= h(i)) {
        val cur = st.top
        st.pop
        res = res.max(h(cur) * (if (st.isEmpty) i else i - st.top - 1))
      }
      st.push(i)
    })
    res
  }
}
