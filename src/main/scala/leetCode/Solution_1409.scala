package leetCode

object Solution_1409 {
  def processQueries(queries: Array[Int], m: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(queries: Array[Int], list: List[Int] = (1 to m).toList, acc: List[Int] = Nil): List[Int] =
      if (queries.isEmpty) acc
      else {
        val pos = list.indexOf(queries.head)
        val split = list.splitAt(pos)
        f(queries.tail, (list(pos) :: split._1) ++ split._2.tail, pos :: acc)
      }

    f(queries).toArray.reverse
  }
}
