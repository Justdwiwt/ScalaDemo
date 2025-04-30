package leetCode._3600

object Solution_3532 {
  def pathExistenceQueries(n: Int, nums: Array[Int], maxDiff: Int, queries: Array[Array[Int]]): Array[Boolean] = {
    val componentIds: Vector[Int] =
      if (n <= 1) Vector.fill(n)(0)
      else nums.sliding(2).foldLeft((Vector(0), 0)) {
        case ((ids, currId), arr) =>
          val prev = arr.head
          val curr = arr(1)
          if (curr - prev <= maxDiff) (ids :+ currId, currId)
          else (ids :+ (currId + 1), currId + 1)
      }._1

    queries.map { case Array(u, v) => componentIds(u) == componentIds(v) }
  }
}
