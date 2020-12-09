package leetCode

object Solution_739 {
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    var st = List.empty[Int]
    val res = Array.fill(T.length)(0)
    T.indices.foreach(i => {
      while (st != Nil && T(st.head) < T(i)) {
        res(st.head) = i - st.head
        st = st.tail
      }
      st = i :: st
    })
    res
  }
}
