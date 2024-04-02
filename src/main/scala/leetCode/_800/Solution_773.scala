package leetCode._800

import scala.collection.mutable

object Solution_773 {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    def solved(board: Array[Array[Int]]): Boolean = board.flatMap(_.toSeq).toSeq == Seq(1, 2, 3, 4, 5, 0)

    def swap(board: Array[Array[Int]], pos1: (Int, Int), pos2: (Int, Int)): Array[Array[Int]] = {
      val _board = board.map(_.clone())
      val tmp = _board(pos1._1)(pos1._2)
      _board(pos1._1)(pos1._2) = _board(pos2._1)(pos2._2)
      _board(pos2._1)(pos2._2) = tmp
      _board
    }

    val visited = mutable.Map.empty[Seq[Int], Int]

    def sliding(board: Array[Array[Int]], moveIdx: (Int, Int), moveCnt: Int): Int =
      if (solved(board)) 0
      else {
        val pos = board.flatMap(_.toSeq)

        if (visited.contains(pos) && visited(pos) < moveCnt + 1) -1
        else {
          visited(pos) = moveCnt

          val tmpMove = Seq(
            (moveIdx._1 + 1, moveIdx._2),
            (moveIdx._1 - 1, moveIdx._2),
            (moveIdx._1, moveIdx._2 + 1),
            (moveIdx._1, moveIdx._2 - 1))

          tmpMove
            .filterNot(move => move._1 < 0 || move._2 < 0 || move._1 >= board.length || move._2 >= board(move._1).length)
            .map(move => {
              val newBoard = swap(board, moveIdx, move)
              val pos = newBoard.flatMap(_.toSeq)

              if (visited.contains(pos) && visited(pos) < moveCnt + 1) -1
              else {
                val res = sliding(newBoard, move, moveCnt + 1)
                if (res == -1) -1
                else res + 1
              }
            })
            .filter(_ != -1)
            .sorted
            .headOption
            .getOrElse(-1)
        }
      }

    val idx = board.indices.flatMap(i => board(i).indices.withFilter(board(i)(_) == 0).map((i, _))).head
    sliding(board, idx, 0)
  }
}
