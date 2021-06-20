package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1600 {
  class ThroneInheritance(_kingName: String) {

    var kingName: String = _kingName
    var m = mutable.HashMap.empty[String, List[String]]
    var st = mutable.HashSet.empty[String]

    m += kingName -> List.empty[String]

    def birth(parentName: String, childName: String) {
      m(parentName) :+= childName
      m += childName -> List.empty[String]
    }

    def death(name: String) {
      st += name
    }

    def getInheritanceOrder: List[String] = {
      val res = ListBuffer.empty[String]
      dfs(res, kingName)
      res.toList
    }

    def dfs(res: ListBuffer[String], name: String): Unit = {
      if (!st.contains(name)) res += name
      m(name).foreach(s => dfs(res, s))
    }

  }
}
