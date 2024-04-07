package leetCode._300

object Solution_246 {
  def isStrobogrammatic(num: String): Boolean = {
    val diff = Map(
      '0' -> '0',
      '1' -> '1',
      '6' -> '9',
      '8' -> '8',
      '9' -> '6'
    )
    num.zipWithIndex.forall { case (c, i) =>
      diff.get(c).contains(num(num.length - 1 - i))
    }
  }
}
