package leetCode._2600

import scala.collection.mutable

object Solution_2532 {
  def findCrossingTime(numBoxes: Int, numWorkers: Int, times: Array[Array[Int]]): Int = {
    val leftBridgeQueue = mutable.PriorityQueue[(Int, Int)]()
    val rightBridgeQueue = mutable.PriorityQueue[(Int, Int)]()
    val leftWarehouseQueue = mutable.PriorityQueue[(Int, Int)]()(Ordering.Tuple2(Ordering.Int.reverse, Ordering.Int))
    val rightWarehouseQueue = mutable.PriorityQueue[(Int, Int)]()(Ordering.Tuple2(Ordering.Int.reverse, Ordering.Int))
    var currentTime = 0
    var remainingBoxes = numBoxes
    (0 until numWorkers).foreach(workerIndex => {
      val totalCrossingTime = times(workerIndex).head + times(workerIndex)(2)
      leftBridgeQueue += ((totalCrossingTime, workerIndex))
    })
    while (remainingBoxes > 0 || rightWarehouseQueue.nonEmpty || rightBridgeQueue.nonEmpty) {
      while (leftWarehouseQueue.nonEmpty && leftWarehouseQueue.head._1 <= currentTime) {
        val (_, workerIndex) = leftWarehouseQueue.dequeue()
        val totalCrossingTime = times(workerIndex).head + times(workerIndex)(2)
        leftBridgeQueue += ((totalCrossingTime, workerIndex))
      }
      while (rightWarehouseQueue.nonEmpty && rightWarehouseQueue.head._1 <= currentTime) {
        val (_, workerIndex) = rightWarehouseQueue.dequeue()
        val totalCrossingTime = times(workerIndex).head + times(workerIndex)(2)
        rightBridgeQueue += ((totalCrossingTime, workerIndex))
      }
      if (rightBridgeQueue.nonEmpty) {
        val (_, workerIndex) = rightBridgeQueue.dequeue()
        val rightToLeftTime = times(workerIndex)(2)
        val leftWarehouseWaitTime = times(workerIndex)(3)
        currentTime += rightToLeftTime
        leftWarehouseQueue += ((currentTime + leftWarehouseWaitTime, workerIndex))
        remainingBoxes -= 1
      }
      else if (leftBridgeQueue.nonEmpty && remainingBoxes > rightWarehouseQueue.size + rightBridgeQueue.size) {
        val (_, workerIndex) = leftBridgeQueue.dequeue()
        val leftToRightTime = times(workerIndex).head
        val rightWarehouseWaitTime = times(workerIndex)(1)
        currentTime += leftToRightTime
        rightWarehouseQueue += ((currentTime + rightWarehouseWaitTime, workerIndex))
      }
      else {
        val leftWarehouseNextTime = if (leftWarehouseQueue.nonEmpty && remainingBoxes > rightWarehouseQueue.size + rightBridgeQueue.size) leftWarehouseQueue.head._1 else Int.MaxValue
        val rightWarehouseNextTime = if (rightWarehouseQueue.nonEmpty) rightWarehouseQueue.head._1 else Int.MaxValue
        currentTime = leftWarehouseNextTime.min(rightWarehouseNextTime)
      }
    }
    currentTime
  }
}
