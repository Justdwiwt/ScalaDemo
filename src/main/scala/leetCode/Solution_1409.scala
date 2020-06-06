package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_1409 {
  def processQueries(queries: Array[Int], m: Int): Array[Int] = {
    var arr = ArrayBuffer.empty[Int]
    (1 to m).foreach(i => arr :+= i)
    queries.indices.foreach(i => {
      val t = arr.indexOf(queries(i))
      arr.remove(t)
      arr +:= queries(i)
      queries(i) = t
    })
    queries
  }
}
