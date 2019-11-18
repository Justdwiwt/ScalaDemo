package leetCode

import scala.collection.mutable

object Solution_811 {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    val m = new mutable.HashMap[String, Int]()
    cpdomains.foreach(i => {
      val t = i.split(" ")
      val c = t(0).toInt
      var v = t(1)
      m.put(v, m.getOrElse(v, 0) + c)
      while (v.indexOf('.') != -1) {
        v = v.replaceFirst("[a-zA-Z]*.", "")
        m.put(v, m.getOrElse(v, 0) + c)
      }
    })
    var res = List[String]()
    m.foreach(i => res ::= (i._2 + " " + i._1))
    res
  }
}
