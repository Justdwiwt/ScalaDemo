package leetCode._900

import scala.collection.mutable

object Solution_841 {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val visited = rooms.map(_ => false).toArray
    val q = mutable.Queue(0)
    while (q.nonEmpty) {
      val room = q.dequeue()
      visited(room) = true
      rooms(room).withFilter(!visited(_)).foreach(q.+=)
    }
    rooms.indices.forall(visited)
  }
}
