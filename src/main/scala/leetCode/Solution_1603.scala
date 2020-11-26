package leetCode

object Solution_1603 {

  class ParkingSystem(_big: Int, _medium: Int, _small: Int) {

    private val arr = Array(this._big, this._medium, this._small)

    def addCar(carType: Int): Boolean = if (arr(carType - 1) > 0) {
      arr(carType - 1) -= 1
      true
    } else false

  }

}
