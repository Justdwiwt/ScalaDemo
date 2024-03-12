package leetCode._1300

object Solution_1276 {
  def numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List[Int] = {
    val m = tomatoSlices - (cheeseSlices << 1)
    if (m < 0 || (m & 1) != 0) return Nil
    val x = m >> 1
    if (cheeseSlices - x < 0) Nil else List(x, cheeseSlices - x)
  }
}
