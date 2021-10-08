package leetCode

import scala.collection.mutable
import scala.util.Random

object Solution_380 {
  class RandomizedSet {
    private val indices = mutable.Map.empty[Int, Int]
    private val values = mutable.ListBuffer.empty[Int]

    def insert(value: Int): Boolean = indices.get(value) match {
      case Some(_) => false
      case None =>
        values.append(value)
        indices.update(value, values.length - 1)
        true
    }

    def remove(value: Int): Boolean = indices.get(value) match {
      case None => false
      case Some(idx) =>
        val last = values.last
        values.remove(values.length - 1)
        indices.remove(value)
        if (idx != values.length) {
          values.update(idx, last)
          indices.update(last, idx)
        }
        true
    }

    def getRandom(): Int = values(Random.nextInt(values.length))
  }
}
