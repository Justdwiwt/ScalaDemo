package leetCode

import scala.collection.mutable

object Solution_975 {

  object Parity extends Enumeration {
    type Parity = Value
    val Even: Parity = Value
    val Odd: Parity = Value
  }

  import Parity._

  def oddEvenJumps(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    val isEndReachable = mutable.Set(a.length - 1 -> Even, a.length - 1 -> Odd)
    val sortedValues = mutable.SortedSet(a(a.length - 1))
    val valueToIndex = mutable.Map(a(a.length - 1) -> (a.length - 1))
    (a.length - 2 to 0 by -1).foreach(i => {
      sortedValues.to(a(i)).lastOption match {
        case Some(j) if isEndReachable.contains(valueToIndex(j) -> Odd) => isEndReachable += i -> Even
        case _ => ()
      }
      sortedValues.from(a(i)).headOption match {
        case Some(j) if isEndReachable.contains(valueToIndex(j) -> Even) => isEndReachable += i -> Odd
        case _ => ()
      }
      sortedValues += a(i)
      valueToIndex += a(i) -> i
    })
    a.indices.count(isEndReachable(_, Odd))
  }

}
