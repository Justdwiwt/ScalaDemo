package leetCode

import scala.collection.mutable

object Solution_1487 {
  def getFolderNames(names: Array[String]): Array[String] = {
    def f(pfx: mutable.LinkedHashSet[String], name: String): String = {
      if (pfx.contains(name)) {
        var s = 1
        var n = name + "(" + s + ")"
        while (pfx.contains(n)) {
          s += 1
          n = name + "(" + s + ")"
        }
        n
      } else name
    }

    val buffer = names./:(mutable.LinkedHashSet[String]()) { case (buffer, name) => buffer += f(buffer, name) }

    buffer.toArray
  }
}
