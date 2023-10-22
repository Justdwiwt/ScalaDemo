package leetCode

object Solution_2525 {
  def categorizeBox(length: Int, width: Int, height: Int, mass: Int): String = (List(length, width, height)
    .exists(_ >= 10000) || length.toLong * width * height >= 1e9.toLong, mass >= 100) match {
    case (true, true) => "Both"
    case (true, false) => "Bulky"
    case (false, true) => "Heavy"
    case (false, false) => "Neither"
  }
}
