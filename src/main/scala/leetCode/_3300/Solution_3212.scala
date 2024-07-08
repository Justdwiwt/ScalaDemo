package leetCode._3300

import scala.collection.immutable.Queue

object Solution_3212 {
  case class State(x: Int, y: Int) {
    def add(other: State): State =
      State(x + other.x, y + other.y)

    def add(c: Char): State =
      if (c == 'X') State(x + 1, y)
      else if (c == 'Y') State(x, y + 1)
      else this

    def isGood: Boolean =
      x == y && x > 0
  }

  def numberOfSubmatrices(grid: Array[Array[Char]]): Int =
    grid.foldLeft((Queue.fill(grid.head.length)(State(0, 0)), 0)) { case ((tops, cnt), chars) =>
      val lefts = chars.foldLeft(Queue(State(0, 0)))((left, c) => left :+ left.last.add(c)).tail
      val row = tops.zip(lefts).map { case (top, left) => top.add(left) }
      (row, cnt + row.count(_.isGood))
    }._2
}
