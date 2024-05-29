package leetCode._2600

object Solution_2509 {
  def cycleLengthQueries(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    @scala.annotation.tailrec
    def getPathUp(n: Int, path: List[Int] = List.empty): List[Int] =
      if (n <= 1) n :: path
      else getPathUp(n / 2, n :: path)

    def forQuery(p: Int, q: Int): Int = {
      val toUpP = getPathUp(p)
      val toUpQ = getPathUp(q)
      val toDrop = toUpP.zip(toUpQ).count { case (a, b) => a == b }
      toUpP.size - toDrop + toUpQ.size - toDrop + 1
    }

    queries.map(arr => forQuery(arr.head, arr(1)))
  }
}
