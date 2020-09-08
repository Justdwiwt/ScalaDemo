package leetCode

//import scala.collection.IterableOps

object Solution_552 {

  // scala 2.13
  //  private implicit class RichIterable[A, CC[_]](lhs: IterableOps[A, CC, _]) {
  //
  //    def x[B](rhs: Iterable[B]): CC[(A, B)] = lhs.flatMap(l => rhs.map(l -> _))
  //  }
  //
  //  private object Attendance extends Enumeration {
  //    type Attendance = Value
  //    val Present, Absent, Late = Value
  //  }
  //
  //  import Attendance._
  //
  //  private lazy val BaseCounts = (values x values)
  //    .flatMap({
  //      case (Absent, Absent) => None
  //      case (Absent, a) => Some((Absent, a, true))
  //      case (a, Absent) => Some((a, Absent, true))
  //      case (a1, a2) => Some((a1, a2, false))
  //    })
  //    .map(_ -> 1)
  //    .toMap
  //
  //  private def add(x: Int, y: Int) = (x + y) % 1000000007
  //
  //  def checkRecord(n: Int): Int = {
  //    if (n == 0) 1
  //    else if (n == 1) 3
  //    else if (n >= 2) (3 to n).foldLeft(BaseCounts) {
  //      case (counts, _) => counts.toSeq.flatMap({
  //        case (Late, Late, true) -> count =>
  //          Seq((Late, Present, true) -> count)
  //        case (Late, Late, false) -> count =>
  //          Seq((Late, Present, false), (Late, Absent, true)).map(_ -> count)
  //        case (_, a, true) -> count =>
  //          Seq((a, Present, true), (a, Late, true)).map(_ -> count)
  //        case (_, a, false) -> count =>
  //          Seq((a, Present, false), (a, Late, false), (a, Absent, true)).map(_ -> count)
  //      }).groupMapReduce(_._1)(_._2)(add)
  //    }.values.reduce(add)
  //    else throw new IllegalArgumentException
  //  }
}
