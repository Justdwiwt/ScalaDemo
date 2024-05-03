package leetCode._300

import scala.collection.mutable

object Solution_281 {

  class ZigzagIterator(v1: Array[Int], v2: Array[Int]) {
    private val queue = mutable.Queue.empty[Iterator[Int]]

    if (v1.nonEmpty) queue.enqueue(v1.iterator)
    if (v2.nonEmpty) queue.enqueue(v2.iterator)

    def next(): Int = {
      val it = queue.dequeue()
      val v = it.next()
      if (it.hasNext) queue.enqueue(it)
      v
    }

    def hasNext: Boolean = queue.nonEmpty
  }

}
