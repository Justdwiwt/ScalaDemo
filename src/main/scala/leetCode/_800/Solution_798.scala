package leetCode._800

object Solution_798 {
  def bestRotation(A: Array[Int]): Int = {
    val n = A.length
    val arr = Array.fill(n)(0)
    A.indices.foreach(i => arr((i - A(i) + 1 + n) % n) -= 1)
    A.indices.drop(1).foldLeft(0)((acc, i) => {
      arr(i) += arr(i - 1) + 1
      if (arr(i) > arr(acc)) i else acc
    })
  }
}
