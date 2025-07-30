package leetCode._3700

object Solution_3609 {
  def minMoves(sx: Int, sy: Int, tx: Int, ty: Int): Int = {
    @scala.annotation.tailrec
    def f(x: Int, y: Int, sX: Int, sY: Int, steps: Int): Int =
      if (x == sX && y == sY) steps
      else if (x < sX || y < sY) -1
      else if (x == y) {
        if (sY > 0) f(0, y, sX, sY, steps + 1)
        else f(x, 0, sX, sY, steps + 1)
      }
      else {
        val (nx, ny, nsx, nsy) =
          if (x < y) (y, x, sY, sX)
          else (x, y, sX, sY)

        if (nx > ny * 2) {
          if (nx % 2 != 0) -1
          else f(nx / 2, ny, nsx, nsy, steps + 1)
        } else f(nx - ny, ny, nsx, nsy, steps + 1)
      }

    f(tx, ty, sx, sy, 0)
  }
}
