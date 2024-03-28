package leetCode._1300

object Solution_1289 {
  def minFallingPathSum(matrix: Array[Array[Int]]): Int = {
    def minExcept(arr: Array[Int], exIdx: Int): Int =
      arr.indices.view.collect { case x if x != exIdx => arr(x) }.min

    def step(s: Array[Int], ns: Array[Int]): Array[Int] = {
      ns.indices.map(i => minExcept(s, i) + ns(i)).toArray
    }

    matrix.tail.foldLeft(matrix.head)(step).min
  }
}
