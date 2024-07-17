package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_16_25 {
  class LRUCache(capacity: Int) {
    private val map = mutable.LinkedHashMap.empty[Int, Int]

    def get(key: Int): Int = map.get(key) match {
      case Some(value) =>
        map -= key
        map += (key -> value)
        value
      case None => -1
    }

    def put(key: Int, value: Int): Unit =
      if (map.contains(key)) {
        map -= key
        map += (key -> value)
      } else {
        map += (key -> value)
        if (map.size > capacity) map -= map.head._1
      }
  }
}
