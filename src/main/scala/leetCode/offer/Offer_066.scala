package leetCode.offer

import scala.collection.mutable

object Offer_066 {
  class MapSum() {

    val m = mutable.Map.empty[String, Int]

    def insert(key: String, value: Int): m.type = m += (key -> value)

    def sum(prefix: String): Int = m.filterKeys(_.startsWith(prefix)).values.sum

  }
}
