package leetCode

import scala.collection.mutable

object Solution_1575 {
  def countRoutes(locations: Array[Int], start: Int, finish: Int, fuel: Int): Int = {
    val dp = mutable.ArrayBuffer(
      IndexedSeq.tabulate(locations.length) {
        case i if i == finish => 1
        case _ => 0
      })

    def f(start: Int, fuel: Int): Int = {
      val numRoutes = locations
        .indices
        .iterator
        .flatMap {
          case i if i != start => fuel - (locations(i) - locations(start)).abs match {
            case remainingFuel if remainingFuel >= 0 => Some(dp(remainingFuel)(i))
            case _ => None
          }
          case _ => None
        }
        ./:(0)((x, y) => (x + y) % 1000000007)
      if (start == finish) numRoutes + 1 else numRoutes
    }

    (1 until fuel).foreach(x => dp += IndexedSeq.tabulate(locations.length)(f(_, x)))

    f(start, fuel)
  }
}
