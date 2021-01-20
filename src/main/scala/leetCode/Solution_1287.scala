package leetCode

object Solution_1287 {
  def findSpecialInteger(arr: Array[Int]): Int =
    arr./:(Map[Int, Int]())((acc, n) => {
      acc + (n -> acc.get(n).fold(1)(_ + 1))
    }).find {
      case (_, n) => (n.toDouble / arr.length) > 0.25
    }.fold(-1) {
      case (n, _) => n
    }
}
