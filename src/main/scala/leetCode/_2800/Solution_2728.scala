package leetCode._2800

object Solution_2728 {
  abstract class Street(doors: Array[Int]) {
    def openDoor(): Unit

    def closeDoor(): Unit

    def isDoorOpen(): Boolean

    def moveRight(): Unit

    def moveLeft(): Unit
  }

  def houseCount(street: Street, k: Int): Int = {
    (0 until k).foreach(i => {
      street.closeDoor()
      street.moveRight()
    })
    var res = 1
    street.openDoor()
    street.moveRight()
    while (!street.isDoorOpen()) {
      res += 1
      street.moveRight()
    }
    res
  }
}
