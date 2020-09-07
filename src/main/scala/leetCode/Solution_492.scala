package leetCode

object Solution_492 {
  def constructRectangle(area: Int): Array[Int] = {
    var t = math.sqrt(area).toInt
    while (area % t != 0) t = t - 1
    Array(area / t, t)
  }
}
