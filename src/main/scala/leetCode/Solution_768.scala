package leetCode

import scala.collection.mutable.Stack

object Solution_768 {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    val st = new Stack[Int]
    arr.indices.foreach(i => {
      if (st.isEmpty || st.top <= arr(i)) st.push(arr(i))
      else {
        val cur = st.top
        st.pop
        while (st.nonEmpty && st.top > arr(i)) st.pop
        st.push(cur)
      }
    })
    st.size
  }
}
