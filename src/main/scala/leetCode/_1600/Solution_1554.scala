package leetCode._1600

import scala.collection.mutable

object Solution_1554 {
  def differByOne(dict: Array[String]): Boolean = {
    val M = 5801
    val n = dict.head.length
    val pow = dict.head.indices.drop(1).scanLeft(1)((acc, _) => acc * 27 % M).toArray

    val m = mutable.Map.empty[Int, List[Int]]

    def checkMatch(k: Int): Boolean = {
      val h = dict(k).foldLeft(0)((acc, c) => (27 * acc + (c - 'a' + 1)) % M)

      def checkIndex(i: Int): Boolean = {
        var found = false
        if (i < n) {
          val t = (h - pow(n - i - 1) * (dict(k)(i) - 'a' + 1) % M + M) % M
          m.get(t).foreach(list => list.foreach(x => {
            val kk = x / n
            val ii = x % n
            if (ii == i && !found) {
              val checked = dict.head.indices.forall(p => p == i || dict(k)(p) == dict(kk)(p))
              if (checked) found = true
            }
          }))
          m.update(t, m.getOrElse(t, Nil) :+ (n * k + i))
          if (!found) found = checkIndex(i + 1)
        }
        found
      }

      checkIndex(0)
    }

    dict.indices.exists(checkMatch)
  }
}
