package leetCode

object Solution_1791 {
  def findCenter(edges: Array[Array[Int]]): Int = {
    val st = Set(edges.head.head, edges.head(1))
    val second = edges(1)
    if (st.contains(second.head)) second.head
    else second(1)
  }
}
