package leetCode._3900

object Solution_3885 {
  class EventManager(_events: Array[Array[Int]]) {

    private val eventOrd: Ordering[Array[Int]] = Ordering.by(a => (a(1), -a.head))

    private val priorities = collection.mutable.Map(_events.map { case Array(id, p) => id -> p }: _*)
    private val pq = collection.mutable.PriorityQueue(_events: _*)(eventOrd)

    def updatePriority(eventId: Int, newPriority: Int): Unit =
      priorities.get(eventId).foreach { priority =>
        priorities.update(eventId, newPriority)
        pq.enqueue(Array(eventId, newPriority))
      }

    @scala.annotation.tailrec
    final def pollHighest(): Int =
      if (pq.isEmpty) -1
      else {
        val Array(id, priority) = pq.dequeue()
        if (priorities.get(id).contains(priority)) {
          priorities.remove(id)
          id
        }
        else pollHighest()
      }
  }
}
