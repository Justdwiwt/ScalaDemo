package leetCode

import scala.collection.mutable

object Solution_841 {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val flag = Array.fill(rooms.length)(false)
    val st = new mutable.Stack[Int]()
    st.push(0)
    flag(0) = true
    while (st.nonEmpty) {
      val door = st.top
      st.pop
      rooms(door).foreach(i => if (!flag(i)) {
        st.push(i)
        flag(i) = true
      })
    }
    flag.foreach(i => if (!i) return false)
    true
  }
}
