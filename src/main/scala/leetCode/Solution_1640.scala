package leetCode

object Solution_1640 {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    @scala.annotation.tailrec
    def f(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
      if (arr.length < 1) true
      else pieces.indexWhere(p => p.nonEmpty && arr.startsWith(p)) match {
        case -1 => false
        case p => f(arr.drop(pieces(p).length), pieces.updated(p, Array()))
      }
    }

    f(arr, pieces)
  }
}
