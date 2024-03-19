package leetCode._2200

object Solution_2127 {
  def maximumInvitations(favorite: Array[Int]): Int = {
    val n = favorite.length
    val (inDegree, dp) = (Array.fill(n)(0), Array.fill(n)(0))
    favorite.foreach(fav => inDegree(fav) += 1)
    val queue = favorite.indices.filter(inDegree(_) == 0)
    val visited = Array.tabulate(n)(i => if (inDegree(i) == 0) 1 else 0)

    @scala.annotation.tailrec
    def topologicalSort(queue: Seq[Int]): Unit = {
      if (queue.isEmpty) return
      val fav = favorite(queue.head)
      dp(fav) = dp(fav).max(dp(queue.head) + 1)
      inDegree(fav) -= 1
      if (inDegree(fav) > 0) topologicalSort(queue.tail)
      else {
        visited(fav) = 1
        topologicalSort(queue.tail :+ fav)
      }
    }

    topologicalSort(queue)

    @scala.annotation.tailrec
    def maxLength(person: Int, length: Int): Int =
      if (visited(person) == 1) length
      else {
        visited(person) = 1
        maxLength(favorite(person), length + 1)
      }

    val (type1, type2) = favorite
      .zipWithIndex
      .foldLeft(0, 0) { case ((type1, type2), (fav, person)) =>
        if (visited(person) == 1) (type1, type2)
        else {
          val length = maxLength(person, length = 0)
          if (length == 2) (type1 + dp(person) + dp(fav) + 2, type2)
          else (type1, type2.max(length))
        }
      }

    type1.max(type2)
  }
}
