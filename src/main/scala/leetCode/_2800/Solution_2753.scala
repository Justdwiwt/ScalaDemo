package leetCode._2800

object Solution_2753 {
  abstract class Street(doors: Array[Int]) {
    def closeDoor(): Unit

    def isDoorOpen(): Boolean

    def moveRight(): Unit
  }

  def houseCount(street: Street, k: Int): Int = {
    while (!street.isDoorOpen()) street.moveRight()
    var res = 0
    (1 to k).foreach(i => {
      street.moveRight()
      if (street.isDoorOpen()) {
        res = i
        street.closeDoor()
      }
    })
    res
  }
}
