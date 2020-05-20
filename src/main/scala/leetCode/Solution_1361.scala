package leetCode

object Solution_1361 {
  def validateBinaryTreeNodes(n: Int, leftChild: Array[Int], rightChild: Array[Int]): Boolean = {
    val diff = Array.fill(n)(0)
    (0 until n).foreach(i => {
      if (~leftChild(i) > 0) diff(leftChild(i)) += 1
      if (~rightChild(i) > 0) diff(rightChild(i)) += 1
    })
    var cnt = 0
    (0 until n).foreach(i => {
      if (diff(i) > 0) {
        if (diff(i) > 1) return false
        cnt += 1
      } else if (n != 1 && leftChild(i) == -1 && leftChild(i) == -1) return false
    })
    cnt + 1 == n
  }
}
