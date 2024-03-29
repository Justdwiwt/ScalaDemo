package leetCode.offer

import scala.collection.mutable

object Offer_041 {
  class MovingAverage(_size: Int) {

    private val size = _size
    private var sum = 0.0
    private val q = mutable.Queue.empty[Int]

    def next(`val`: Int): Double = {
      q += `val`
      sum += `val`
      if (q.size > size) {
        sum -= q.front
        q.dequeue()
      }
      sum / q.size
    }

  }
}
