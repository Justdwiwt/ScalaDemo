package leetCode._200

object Solution_174 {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val m = dungeon.length
    val n = dungeon.head.length

    val v = (m - 1 to 0 by -1).foldLeft(Vector.fill(n)(Int.MaxValue))((downRow, i) => {
      (n - 1 to 0 by -1).scanLeft(Integer.MAX_VALUE) {
        (rightCell, j) => {
          val downCell = downRow(j)
          val cur = dungeon(i)(j)
          val nextCell = rightCell.min(downCell)
          if (nextCell == Integer.MAX_VALUE)
            if (cur < 0) 1 - cur
            else 1
          else 1.max(nextCell - cur)
        }
      }.toVector.reverse
    })

    v.head
  }
}
