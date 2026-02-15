package leetCode._3900

object Solution_3829 {
  class RideSharingSystem {

    private val driverQueue: collection.mutable.Queue[Int] = collection.mutable.Queue()
    private val riderSet: collection.mutable.LinkedHashSet[Int] = collection.mutable.LinkedHashSet()

    def addRider(riderId: Int): Unit =
      riderSet.add(riderId)

    def addDriver(driverId: Int): Unit =
      driverQueue.enqueue(driverId)

    def matchDriverWithRider(): Array[Int] = {
      if (driverQueue.isEmpty || riderSet.isEmpty) return Array(-1, -1)

      val rider: Int = riderSet.head
      riderSet.remove(rider)
      Array(driverQueue.dequeue(), rider)
    }

    def cancelRider(riderId: Int): Unit =
      riderSet.remove(riderId)
  }
}
