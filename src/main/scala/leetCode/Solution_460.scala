package leetCode

import scala.collection.mutable

object Solution_460 {
  class LFUCache(_capacity: Int) {
    val cache: mutable.Map[Int, (Int, Int)] = mutable.LinkedHashMap[Int, (Int, Int)]().withDefaultValue((-1, 0))
    val capacity: Int = _capacity

    def get(key: Int): Int = {
      if (cache.contains(key)) {
        val (v, cnt) = cache(key)
        cache.remove(key)
        cache.put(key, (v, cnt + 1))
      }
      cache(key)._1
    }

    def put(key: Int, value: Int): Unit =
      if (capacity != 0) {
        if (cache.contains(key))
          cache.put(key, (value, cache(key)._2 + 1))
        else if (cache.size == capacity) {
          cache.remove(cache.minBy(_._2._2)._1)
          cache.put(key, (value, 1))
        }
        else cache.put(key, (value, 1))
      }
  }
}
