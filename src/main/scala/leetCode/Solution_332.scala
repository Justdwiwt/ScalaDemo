package leetCode

import scala.collection.mutable.ListBuffer

object Solution_332 {
  def findItinerary(tickets: List[List[String]]): List[String] = {
    val res = new ListBuffer[String]
    val m = new java.util.HashMap[String, java.util.PriorityQueue[String]]()
    if (tickets.isEmpty) return List.empty
    var src: String = null
    var target: String = null
    tickets.foreach(i => {
      src = i.head
      target = i(1)
      if (!m.containsKey(src)) m.put(src, new java.util.PriorityQueue[String]())
      m.get(src).offer(target)
    })
    dfs("JFK")

    def dfs(cur: String): Unit = {
      while (m.containsKey(cur) && !m.get(cur).isEmpty) {
        val t = m.get(cur).poll()
        dfs(t)
      }
      res += cur
    }

    res.toList.reverse
  }
}
