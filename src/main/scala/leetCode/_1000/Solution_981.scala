package leetCode._1000

import java.util

import scala.collection.mutable

object Solution_981 {

  class TimeMap() {

    private val m = mutable.Map[String, util.TreeMap[Int, String]]()

    def set(key: String, value: String, timestamp: Int) {
      val updated = m.getOrElse(key, new util.TreeMap[Int, String]())
      updated.put(timestamp, value)
      m.update(key, updated)
    }

    def get(key: String, timestamp: Int): String = {
      m.get(key).flatMap(treeMap => {
        val key = Option(treeMap.floorKey(timestamp))
        key.flatMap(value => Option(treeMap.get(value)))
      }).getOrElse("")

    }

  }

}
