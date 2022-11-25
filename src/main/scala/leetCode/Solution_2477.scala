package leetCode

import scala.collection.immutable.{Map, Set}

object Solution_2477 {
  def minimumFuelCost(roads: Array[Array[Int]], seats: Int): Long = {
    val children = roads
      ./:(Map[Int, Set[Int]]().withDefaultValue(Set[Int]())) { case (map, Array(x, y)) => map + (x -> (map(x) + y)) + (y -> (map(y) + x)) }

    def f(root: Int, next: Set[Int]): (Long, Long) = next.size match {
      case 0 => (0, 1)
      case _ => next
        .toList
        .map(x => f(x, children(x) - root))
        ./:(0L, 1L) { case ((fu, pe), (f, p)) => (fu + f + math.ceil(p.toDouble / seats).toLong, pe + p) }
    }

    f(0, children(0))._1
  }
}
