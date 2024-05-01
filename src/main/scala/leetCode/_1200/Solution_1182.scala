package leetCode._1200

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1182 {
  def shortestDistanceColor(colors: Array[Int], queries: Array[Array[Int]]): List[Int] = {
    val sets = ArrayBuffer.fill(3)(mutable.TreeSet.empty[Int])

    colors.indices.foreach(i => sets(colors(i) - 1).add(i))

    val list = ArrayBuffer.empty[Int]

    queries.foreach(query => {
      val set = sets(query(1) - 1)
      val i = set.rangeImpl(None, Some(query.head)).lastOption
      val j = set.rangeImpl(Some(query.head), None).headOption

      var x = colors.length

      if (i.isDefined) x = x.min((query.head - i.get).abs)
      if (j.isDefined) x = x.min((query.head - j.get).abs)

      list.append(if (x == colors.length) -1 else x)
    })

    list.toList
  }
}
