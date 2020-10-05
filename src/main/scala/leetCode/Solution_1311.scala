package leetCode

import java.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_1311 {
  def watchedVideosByFriends(watchedVideos: List[List[String]], friends: Array[Array[Int]], id: Int, level: Int): List[String] = {
    val m = new util.HashMap[String, Int]()
    val q = new util.LinkedList[Int]()
    var visited = new mutable.HashSet[Int]()
    q.addLast(id)
    visited += id
    var depth = -1
    breakable {
      while (!q.isEmpty) {
        depth += 1
        if (depth >= level) {
          q.forEach(fri => watchedVideos(fri).foreach(s => m.put(s, m.getOrDefault(s, 0) + 1)))
          break()
        }
        val size = q.size()
        (0 until size).foreach(_ => {
          val fir = q.removeFirst()
          friends(fir).foreach(f => {
            if (!visited.contains(f)) {
              q.addLast(f)
              visited += f
            }
          })
        })
      }
    }
    val list = new util.ArrayList[String](m.keySet)
    list.sort((o1, o2) => if (m.get(o1).equals(m.get(o2))) o1.compareTo(o2) else m.get(o1) - m.get(o2))
    var res = ListBuffer.empty[String]
    list.forEach(i => res += i)
    res.toList
  }
}
