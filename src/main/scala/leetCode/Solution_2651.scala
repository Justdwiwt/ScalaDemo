package leetCode

object Solution_2651 {
  def findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int =
    (arrivalTime + delayedTime) % 24
}
