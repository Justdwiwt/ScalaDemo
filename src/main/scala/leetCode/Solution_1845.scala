package leetCode

import scala.collection.mutable

object Solution_1845 {

  class SeatManager(_n: Int) {
    var pq: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int](-_n to -1: _*)

    def reserve(): Int =
      -pq.dequeue()

    def unreserve(seatNumber: Int) {
      pq.enqueue(-seatNumber)
    }

  }

}
