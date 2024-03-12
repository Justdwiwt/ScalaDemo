package leetCode._2700

object Solution_2651 {
  def findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int =
    (arrivalTime + delayedTime) % 24
}
