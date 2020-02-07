package leetCode

object Solution_546 {
  def removeBoxes(boxes: Array[Int]): Int = {
    val dp = Array.ofDim[Int](100, 100, 100)
    func(boxes, dp, 0, boxes.length - 1, 0)
  }

  def func(boxes: Array[Int], dp: Array[Array[Array[Int]]], _i: Int, _j: Int, _k: Int): Int = {
    if (_i > _j) return 0
    var (i, j, k) = (_i, _j, _k)
    while (j > 0 && boxes(j - 1) == boxes(j)) {
      j -= 1
      k += 1
    }
    if (dp(i)(j)(k) == 0) {
      dp(i)(j)(k) = func(boxes, dp, i, j - 1, 0) + (k + 1) * (k + 1)
      (i until j).foreach(idx => if (boxes(idx) == boxes(j)) dp(i)(j)(k) = dp(i)(j)(k).max(func(boxes, dp, i, idx, k + 1) + func(boxes, dp, idx + 1, j - 1, 0)))
    }
    dp(i)(j)(k)
  }
}
