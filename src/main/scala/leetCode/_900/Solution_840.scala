package leetCode._900

import scala.collection.immutable.BitSet

object Solution_840 {
  private val OneToNine = BitSet(1 to 9: _*)

  def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.headOption.map(_.length).getOrElse(0)

    Iterator
      .range(0, m - 2)
      .flatMap(row => Iterator.tabulate(n - 2)(row -> _))
      .count {
        case (row, col) => BitSet(row until row + 3: _*)
          .flatMap(i => (col until col + 3).map(grid(i)(_))) == OneToNine && {
          val sum = Iterator.range(0, 3).map(k => grid(row + k)(col + 2 - k)).sum
          Iterator(Iterator.range(0, 3).map(k => grid(row + k)(col + k)).sum)
            .++(Iterator.range(row, row + 3).map(i => Iterator.range(col, col + 3).map(grid(i)(_)).sum))
            .++(Iterator.range(col, col + 3).map(j => Iterator.range(row, row + 3).map(grid(_)(j)).sum))
            .forall(_ == sum)
        }
      }
  }
}
