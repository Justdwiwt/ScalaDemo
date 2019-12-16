package leetCode

object Solution_1128 {
  def numEquivDominoPairs(A: Array[Array[Int]]): Int = {
    A.groupBy({ case Array(x, y) => (x min y, x max y) }).values.toList.foldLeft(0)((sum, x) => sum + x.length * (x.length - 1) / 2)
  }
}
