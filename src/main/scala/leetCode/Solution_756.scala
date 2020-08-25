package leetCode

import scala.collection.mutable

object Solution_756 {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    var m = new mutable.HashMap[String, Array[Char]]()
    allowed.foreach(a => {
      var c = a(2)
      val child = a.substring(0, 2)
      if (!m.contains(child)) m += child -> Array.empty
      m(child) :+= c
    })

    def dfs(last: String, now: String): Boolean = {
      if (last.length == 1) return true
      if (now.length + 1 == last.length) return dfs(now, "")
      val child = last.substring(now.length, now.length + 2)
      if (!m.contains(child)) return false
      m(child).foreach(c => if (dfs(last, now + c)) return true)
      false
    }

    dfs(bottom, "")
  }
}
