package leetCode._1400

import scala.collection.mutable

object Solution_1391 {
  trait Direction {
    def dy: Int = 0

    def dx: Int = 0

    def reversed: Direction
  }

  case object Up extends Direction {
    override val dy: Int = -1
    val reversed: Direction = Down
  }

  case object Down extends Direction {
    override val dy = 1
    val reversed: Direction = Up
  }

  case object Left extends Direction {
    override val dx: Int = -1
    val reversed: Direction = Right
  }

  case object Right extends Direction {
    override val dx = 1
    val reversed: Direction = Left
  }

  case class Pos(y: Int, x: Int) {
    def traverse(dir: Direction): Pos =
      Pos(y + dir.dy, x + dir.dx)

    def isValid(yMax: Int, xMax: Int): Boolean =
      y >= 0 && y < yMax && x >= 0 && x < xMax
  }

  private val directions = Array(Up, Down, Left, Right)

  private def canTraverse(street: Int, d: Direction): Boolean = street match {
    case 1 => d == Left || d == Right
    case 2 => d == Up || d == Down
    case 3 => d == Down || d == Left
    case 4 => d == Down || d == Right
    case 5 => d == Up || d == Left
    case 6 => d == Up || d == Right
    case _ => false
  }

  def hasValidPath(grid: Array[Array[Int]]): Boolean = {
    val yMax = grid.length
    val xMax = grid.head.length

    val finalPos = Pos(yMax - 1, xMax - 1)

    val stack = mutable.Stack[Pos]()
    stack.push(Pos(0, 0))

    while (stack.nonEmpty) {
      val pos = stack.pop()

      if (pos == finalPos) return true

      val street = grid(pos.y)(pos.x)
      grid(pos.y)(pos.x) = 0

      directions
        .withFilter(dir => canTraverse(street, dir))
        .foreach(dir => {
          val newPos = pos.traverse(dir)
          if (newPos.isValid(yMax, xMax) && canTraverse(grid(newPos.y)(newPos.x), dir.reversed))
            stack.push(newPos)
        })
    }

    false
  }
}
