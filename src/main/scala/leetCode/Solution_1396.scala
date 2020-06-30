package leetCode

import scala.collection.mutable

object Solution_1396 {

  class UndergroundSystem() {
    val in = new mutable.HashMap[Int, (String, Int)]()
    val out = new mutable.HashMap[(String, String), List[Int]]()

    def checkIn(id: Int, stationName: String, t: Int) {
      in.put(id, (stationName, t))
    }

    def checkOut(id: Int, stationName: String, t: Int) {
      in(id) match {
        case (startStation, startTime) =>
          out.put((startStation, stationName), (t - startTime) :: out.getOrElse((startStation, stationName), Nil))
      }
    }

    def getAverageTime(startStation: String, endStation: String): Double = {
      val l = out.getOrElse((startStation, endStation), Nil)
      l.sum.toDouble / l.length
    }

  }

}
