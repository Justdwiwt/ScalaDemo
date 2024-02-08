package leetCode

object Code_16_13 {
  def cutSquares(square1: Array[Int], square2: Array[Int]): Array[Double] = {
    val top = (square1(1) + square1(2)).max(square2(1) + square2(2))
    val bottom = square1(1).min(square2(1))
    val left = square1.head.min(square2.head)
    val right = (square1.head + square1(2)).max(square2.head + square2(2))

    val cx1 = ((square1.head << 1) + square1(2)) / 2.0
    val cx2 = ((square2.head << 1) + square2(2)) / 2.0
    val cy1 = ((square1(1) << 1) + square1(2)) / 2.0
    val cy2 = ((square2(1) << 1) + square2(2)) / 2.0

    if ((cx1 - cx2).abs < 1e-6) return Array(cx1, bottom, cx1, top)
    if ((cy1 - cy2).abs < 1e-6) return Array(left, cy1, right, cy1)

    val y = (cy1 * (left - cx2) - cy2 * (left - cx1)) / (cx1 - cx2)

    if (y >= bottom && y <= top) return Array(left, y, right, (cy1 * (right - cx2) - cy2 * (right - cx1)) / (cx1 - cx2))

    val bottomX = (cx1 * (bottom - cy2) - cx2 * (bottom - cy1)) / (cy1 - cy2)
    val topX = (cx1 * (top - cy2) - cx2 * (top - cy1)) / (cy1 - cy2)

    if (bottomX < topX) Array(bottomX, bottom, topX, top) else Array(topX, top, bottomX, bottom)
  }
}
