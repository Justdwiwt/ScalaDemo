package leetCode

import scala.collection.mutable

object Solution_1487 {
  def getFolderNames(names: Array[String]): Array[String] = {
    var arr = mutable.ArrayBuffer.empty[String]
    val m = new mutable.HashMap[String, Int]()
    names.indices.foreach(i => {
      var t = names(i)
      if (m.contains(t)) {
        var num = m(t)
        num += 1
        var str = t + "(" + num + ")"
        while (m.contains(str)) {
          num += 1
          str = t + "(" + num + ")"
        }
        m.put(t, num)
        arr += str
        m.put(str, 0)
      } else {
        m.put(t, 0)
        arr += t
      }
    })
    arr.toArray
  }
}
