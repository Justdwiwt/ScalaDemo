package leetCode

object Solution_1276 {
  def numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List[Int] = {
    if (tomatoSlices == 0 && cheeseSlices == 0) return List(0, 0)
    if (tomatoSlices <= 0 || cheeseSlices <= 0) return List.empty
    if (tomatoSlices % 2 == 0) {
      val a = tomatoSlices / 2 - cheeseSlices
      val b = 2 * cheeseSlices - tomatoSlices / 2
      if (a >= 0 && b >= 0) List(a, b) else List.empty
    } else List.empty
  }
}
