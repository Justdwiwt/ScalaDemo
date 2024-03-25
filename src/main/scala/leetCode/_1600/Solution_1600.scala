package leetCode._1600

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1600 {
  class ThroneInheritance(_kingName: String) {

    private var kingName: String = _kingName
    var m = mutable.HashMap.empty[String, List[String]]
    var st = mutable.HashSet.empty[String]

    m += kingName -> List.empty[String]

    def birth(parentName: String, childName: String): Unit = {
      m(parentName) :+= childName
      m += childName -> List.empty[String]
    }

    def death(name: String): Unit = {
      st += name
    }

    def getInheritanceOrder: List[String] = {
      val res = ListBuffer.empty[String]
      dfs(res, kingName)
      res.toList
    }

    private def dfs(res: ListBuffer[String], name: String): Unit = {
      if (!st.contains(name)) res += name
      m(name).foreach(dfs(res, _))
    }

  }
}
