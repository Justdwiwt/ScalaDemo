package leetCode._900

object Solution_821 {
  def shortestToChar(S: String, C: Char): Array[Int] = {
    def CIndices(S: String, idx: Int): List[Int] =
      if (S.isEmpty) Nil
      else if (S.head == C) idx :: CIndices(S.tail, idx + 1)
      else CIndices(S.tail, idx + 1)

    @scala.annotation.tailrec
    def minDist(list: List[Int], idx: Int, minSoFar: Int): Int = list match {
      case Nil => minSoFar
      case x :: xs => if ((x - idx).abs < minSoFar) minDist(xs, idx, (x - idx).abs) else minDist(xs, idx, minSoFar)
    }

    S.indices.map(minDist(CIndices(S, 0), _, S.length)).toArray
  }
}
