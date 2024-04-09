package leetCode._100

object Solution_85 {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    @scala.annotation.tailrec
    def largestRectangleArea(heights: List[Int], maxVal: Int = 0): Int =
      if (heights.isEmpty) maxVal
      else largestRectangleArea(heights.tail, maxVal.max(heights.min * heights.size))

    @scala.annotation.tailrec
    def check(row: Int, col: Int, heights0: List[Int], maxArea: Int): Int = {
      val ZERO = '0'
      if (row == matrix.length) maxArea
      else if (col == matrix.head.length) check(row + 1, 0, Nil, maxArea)
      else if (matrix(row)(col) == ZERO) check(row, col + 1, Nil, maxArea)
      else {
        val height = (row until matrix.length).find(matrix(_)(col) == ZERO).getOrElse(matrix.length) - row
        val heights = height +: heights0
        val area = largestRectangleArea(heights.reverse)
        check(row, col + 1, heights, area.max(maxArea))
      }
    }

    check(0, 0, Nil, 0)
  }
}
