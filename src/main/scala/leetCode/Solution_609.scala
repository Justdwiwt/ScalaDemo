package leetCode

import scala.collection.mutable

object Solution_609 {
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val m = mutable.HashMap[String, mutable.ListBuffer[String]]()
    paths.foreach(path => {
      val parts = path.split(" ")
      val root = parts.head
      parts.tail.foreach(p => {
        val first = p.indexOf('(')
        val second = p.indexOf(')')
        val fileName = p.take(first)
        val content = p.substring(first + 1, second)
        if (!m.contains(content)) m += content -> mutable.ListBuffer[String]()
        m(content) += s"$root/$fileName"
      })
    })
    m.values.toList.map(_.toList).filter(x => x.size > 1)
  }
}
