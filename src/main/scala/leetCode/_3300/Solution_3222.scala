package leetCode._3300

object Solution_3222 {
  def losingPlayer(x: Int, y: Int): String = {
    val minVal = (a: Int, b: Int) => a.min(b)
    val determinePlayer = (value: Int) => if (value % 2 == 0) "Bob" else "Alice"
    determinePlayer(minVal(x, y / 4))
  }
}
