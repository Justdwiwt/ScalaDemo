package leetCode._1600

object Solution_1529 {
  def minFlips(target: String): Int = target./:(0) {
    case (numFlips, bulb) if numFlips % 2 != bulb - '0' => numFlips + 1
    case (numFlips, _) => numFlips
  }
}
