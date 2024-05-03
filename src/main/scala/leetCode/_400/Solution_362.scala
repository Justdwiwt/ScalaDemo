package leetCode._400

import scala.collection.mutable

object Solution_362 {

  class HitCounter {
    private val q = mutable.Queue.empty[Int]

    def hit(timestamp: Int): Unit =
      q.enqueue(timestamp)

    def getHits(timestamp: Int): Int = {
      while (q.nonEmpty && timestamp - q.front >= 300)
        q.dequeue()
      q.size
    }
  }

}
