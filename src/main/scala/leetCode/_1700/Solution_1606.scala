package leetCode._1700

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1606 {
  //  def busiestServers(k: Int, arrival: Array[Int], load: Array[Int]): List[Int] = {
  //    val availableServers = mutable.TreeSet[Int](Range(0, k).toList: _*)
  //    val busyServers = mutable.TreeMap[Int, ListBuffer[Int]]().withDefaultValue(ListBuffer.empty[Int])
  //    val count = Array.fill[Int](k)(0)
  //    var maxRequest = 0
  //
  //    arrival.zipWithIndex.foreach { case (arrivalTime, requestIdx) =>
  //      busyServers.rangeTo(arrivalTime).foreach { case (endTime, servers) =>
  //        servers.foreach { server =>
  //          availableServers.add(server)
  //        }
  //        busyServers.remove(endTime)
  //      }
  //
  //      val fromNatural = availableServers.rangeFrom(requestIdx % k).headOption
  //      val fromStart = availableServers.rangeUntil(requestIdx % k).headOption
  //
  //      val headOpt = (fromNatural, fromStart) match {
  //        case (Some(_), _) => fromNatural
  //        case (_, Some(_)) => fromStart
  //        case (_, _) => None
  //      }
  //
  //      headOpt.map(server => {
  //        availableServers.remove(server)
  //        busyServers.put(arrivalTime + load(requestIdx), busyServers(arrivalTime + load(requestIdx)) :+ server)
  //        count(server) += 1
  //        maxRequest = maxRequest.max(count(server))
  //      })
  //    }
  //
  //    count.zipWithIndex.filter(_._1 == maxRequest).map(_._2).toList
  //  }
}
