package leetCode

object Solution_1210 {
  private val Empty = 0

  def minimumMoves(grid: Array[Array[Int]]): Int = {
    trait Snake {
      def row: Int

      def col: Int

      final def moves: Iterable[Snake] = Iterable(moveDown, moveRight, rotate).flatten

      protected def moveDown: Option[Snake]

      protected def moveRight: Option[Snake]

      protected def rotate: Option[Snake]
    }

    final case class HorizontalSnake(override val row: Int, override val col: Int) extends Snake {
      override protected def moveDown: Option[HorizontalSnake] = {
        (grid.get(row + 1, col), grid.get(row + 1, col - 1)) match {
          case (Some(Empty), Some(Empty)) => Some(HorizontalSnake(row + 1, col))
          case _ => None
        }
      }

      override protected def moveRight: Option[HorizontalSnake] = grid.get(row, col + 1) match {
        case Some(Empty) => Some(HorizontalSnake(row, col + 1))
        case _ => None
      }

      override protected def rotate: Option[VerticalSnake] = {
        (grid.get(row + 1, col), grid.get(row + 1, col - 1)) match {
          case (Some(Empty), Some(Empty)) => Some(VerticalSnake(row + 1, col - 1))
          case _ => None
        }
      }
    }

    final case class VerticalSnake(override val row: Int, override val col: Int) extends Snake {
      override protected def moveDown: Option[VerticalSnake] = grid.get(row + 1, col) match {
        case Some(Empty) => Some(VerticalSnake(row + 1, col))
        case _ => None
      }

      override protected def moveRight: Option[VerticalSnake] = {
        (grid.get(row, col + 1), grid.get(row - 1, col + 1)) match {
          case (Some(Empty), Some(Empty)) => Some(VerticalSnake(row, col + 1))
          case _ => None
        }
      }

      override protected def rotate: Option[HorizontalSnake] = {
        (grid.get(row, col + 1), grid.get(row - 1, col + 1)) match {
          case (Some(Empty), Some(Empty)) => Some(HorizontalSnake(row - 1, col + 1))
          case _ => None
        }
      }
    }

    @scala.annotation.tailrec
    def search(snakes: Set[Snake], visited: Set[Snake] = Set(), numMoves: Int = 0): Int =
      if (snakes.isEmpty) -1
      else if (snakes.contains(HorizontalSnake(grid.length - 1, grid.head.length - 1))) numMoves
      else search(snakes.flatMap(_.moves).diff(visited), visited ++ snakes, numMoves + 1)

    search(Set(HorizontalSnake(0, 1)))
  }

  private implicit class Rich2dArray[+A](array: Array[Array[A]]) {
    def get(row: Int, col: Int): Option[A] =
      if (array.isDefinedAt(row) && array(row).isDefinedAt(col)) Some(array(row)(col))
      else None
  }
}
