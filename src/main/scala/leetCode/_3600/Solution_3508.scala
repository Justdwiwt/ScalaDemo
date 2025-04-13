package leetCode._3600

import scala.collection.mutable

object Solution_3508 {
  class Router(_memoryLimit: Int) {
    private val memoryLimit = _memoryLimit
    private val packetQueue = mutable.Queue[(Int, Int, Int)]()
    private val packetSet = mutable.HashSet[(Int, Int, Int)]()
    private val destToTimestamps = mutable.Map[Int, (mutable.ArrayBuffer[Int], Int)]()

    def addPacket(source: Int, destination: Int, timestamp: Int): Boolean = {
      val packet = (source, destination, timestamp)
      if (!packetSet.add(packet)) return false
      if (packetQueue.size == memoryLimit) forwardPacket()
      packetQueue.enqueue(packet)
      val (timestamps, _) = destToTimestamps.getOrElseUpdate(destination, (mutable.ArrayBuffer[Int](), 0))
      timestamps.append(timestamp)
      true
    }

    private def forwardPacket(): Array[Int] = {
      if (packetQueue.isEmpty) return Array()
      val (source, destination, timestamp) = packetQueue.dequeue()
      packetSet.remove((source, destination, timestamp))
      val (timestamps, head) = destToTimestamps(destination)
      destToTimestamps.update(destination, (timestamps, head + 1))
      Array(source, destination, timestamp)
    }

    def getCount(destination: Int, startTime: Int, endTime: Int): Int = {
      destToTimestamps.get(destination) match {
        case Some((timestamps, head)) =>
          val slice = timestamps.view.slice(head, timestamps.length)
          val left = slice.indexWhere(_ >= startTime) match {
            case -1 => slice.length
            case idx => idx
          }
          val right = slice.lastIndexWhere(_ <= endTime) match {
            case -1 => -1
            case idx => idx
          }
          if (right >= left) right - left + 1 else 0
        case None => 0
      }
    }
  }
}
