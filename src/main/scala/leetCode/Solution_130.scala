package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_130 {
  def solve(board: Array[Array[Char]]): Unit = {
    if (board.isEmpty || board(0).isEmpty) return
    board.indices.foreach(i => board(0).indices.foreach(j => {
      breakable {
        if (i != 0 && i != board.length - 1 && j != 0 && j != board(0).length - 1) break
      }
      breakable {
        if (board(i)(j) != 'O') break
      }
      board(i)(j) = '$'
      val q = new mutable.Queue[Int]()
      q.enqueue(i * board(0).length + j)
      while (q.nonEmpty) {
        val t = q.front
        val x = t / board(0).length
        val y = t % board(0).length
        q.dequeue
        if (x >= 1 && board(x - 1)(y) == 'O') {
          board(x - 1)(y) = '$'
          q.enqueue(t - board(0).length)
        }
        if (x < board.length - 1 && board(x + 1)(y) == 'O') {
          board(x + 1)(y) == '$'
          q.enqueue(t + board(0).length)
        }
        if (y >= 1 && board(x)(y - 1) == 'O') {
          board(x)(y - 1) == '$'
          q.enqueue(t - 1)
        }
        if (y < board(0).length - 1 && board(x)(y + 1) == 'O') {
          board(x)(y + 1) == '$'
          q.enqueue(t + 1)
        }
      }
    }))
    board.indices.foreach(i => board(0).indices.foreach(j => {
      if (board(i)(j) == 'O') board(i)(j) = 'X'
      if (board(i)(j) == '$') board(i)(j) = 'O'
    }))
  }
}
