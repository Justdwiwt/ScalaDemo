package leetCode

//import scala.collection.SortedSet
//
//object AStar {
//  def searchUnitCost[S](start: S, isEnd: S => Boolean, neighbors: S => Iterable[S]): Option[Int] =
//    searchUnitCost(start, isEnd, neighbors, (_: S) => 0)
//
//  def searchUnitCost[S, C](start: S, isEnd: S => Boolean, neighbors: S => Iterable[S], heuristic: S => C)(implicit numeric: Numeric[C]): Option[C] =
//    search(start, isEnd, neighbors(_: S).map(_ -> numeric.one), heuristic)
//
//  def search[S, C](start: S, isEnd: S => Boolean, neighbors: S => Iterable[(S, C)])(implicit numeric: Numeric[C]): Option[C] =
//    search(start, isEnd, neighbors, (_: S) => numeric.zero)
//
//  def search[S, C](start: S, isEnd: S => Boolean, neighbors: S => Iterable[(S, C)], heuristic: S => C)(implicit numeric: Numeric[C]): Option[C] = {
//    import numeric.{mkNumericOps, mkOrderingOps, zero}
//
//    implicit val ordering: Ordering[(S, C)] = Ordering.by { case (state, cost) => (cost + heuristic(state), System.identityHashCode(state)) }
//
//    @scala.annotation.tailrec
//    def search(states: SortedSet[(S, C)], costs: Map[S, C]): Option[C] = states.headOption match {
//      case Some(state -> cost) if isEnd(state) => Some(cost)
//      case Some(state1 -> cost1) if costs.get(state1).forall(cost1 < _) =>
//        search(states.tail ++ neighbors(state1).map { case (state2, cost2) => (state2, cost1 + cost2) }, costs + (state1 -> cost1))
//      case Some(_) => search(states.tail, costs)
//      case _ => None
//    }
//
//    search(SortedSet(start -> zero), Map())
//  }
//}
//
//object Solution_1293 {
//  private val Empty = 0
//  private val Obstacle = 1
//
//  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
//    val numRows = grid.length
//    val numCols = grid.headOption.map(_.length).getOrElse(0)
//
//    final case class State(row: Int, col: Int, k: Int) {
//
//      def heuristic: Int = (numRows - row - 1) + (numCols - col - 1)
//
//      def isEnd: Boolean = row == numRows - 1 && col == numCols - 1
//
//      def neighbors: Iterable[State] = Iterable((row + 1, col), (row - 1, col), (row, col + 1), (row, col - 1))
//        .filter { case (row, col) => grid.isDefinedAt(row) && grid(row).isDefinedAt(col) }
//        .collect {
//          case (row, col) if grid(row)(col) == Empty => State(row, col, k)
//          case (row, col) if grid(row)(col) == Obstacle && k > 0 => State(row, col, k - 1)
//        }
//    }
//
//    AStar.searchUnitCost(State(0, 0, k), (_: State).isEnd, (_: State).neighbors, (_: State).heuristic).getOrElse(-1)
//  }
//}
