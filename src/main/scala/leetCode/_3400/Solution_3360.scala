package leetCode._3400

object Solution_3360 {
  def canAliceWin(n: Int): Boolean =
    ((21 - math.ceil(math.sqrt(441 - n * 8))).toInt / 2) % 2 > 0
}
