package leetCode._1900

import scala.collection.immutable.SortedSet

object Solution_1847 {
  // TODO:  

  //  def closestRoom(rooms: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
  //    rooms.sortInPlaceBy { case Array(id, size) => (-size, id) }
  //
  //    val indices = queries.indices.sortBy(i => -queries(i)(1))
  //
  //    val res = Array.fill(queries.length)(-1)
  //
  //    indices
  //      .iterator
  //      .zip(indices
  //        .iterator
  //        .map(queries(_)(1))
  //        .scanLeft(SortedSet.empty[Int], rooms.iterator) {
  //          case ((ids, it), minSize) => it.span(_ (1) >= minSize) match {
  //            case (prefix, suffix) => (ids ++ prefix.map(_.head), suffix)
  //          }
  //        }
  //        .map(_._1)
  //        .drop(1))
  //      .foreach { case (i, ids) =>
  //        res(i) = Iterator(ids.rangeTo(queries(i).head).lastOption, ids.rangeFrom(queries(i).head).headOption)
  //          .flatten
  //          .minByOption(id => (id - queries(i)(0)).abs)
  //          .getOrElse(-1)
  //      }
  //
  //    res
  //  }
}
