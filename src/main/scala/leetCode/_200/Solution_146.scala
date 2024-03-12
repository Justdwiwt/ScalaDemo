package leetCode._200

import scala.collection.mutable

object Solution_146 {
  class LRUCache(_capacity: Int) {

    val cache: mutable.LinkedHashMap[Int, Int] = mutable.LinkedHashMap.empty[Int, Int]

    def get(key: Int): Int = cache.remove(key) match {
      case None => -1
      case Some(value) =>
        cache += key -> value
        value
    }

    def put(key: Int, value: Int): Unit = {
      cache += key -> value
      get(key)
      if (cache.size > _capacity) cache.remove(cache.head._1)
    }

  }
}
