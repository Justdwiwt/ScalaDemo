package leetCode._1300

object Solution_1289 {
  def minFallingPathSum(arr: Array[Array[Int]]): Int = {
    (0 to arr.length - 2).reverse.foreach(i => arr.indices.foreach(j => {
      var mn = Int.MaxValue
      arr.indices.foreach(k => if (k != j) mn = mn.min(arr(i + 1)(k)))
      arr(i)(j) += mn
    }))
    var res = Int.MaxValue
    arr.indices.foreach(i => res = res.min(arr(0)(i)))
    res
  }
}
