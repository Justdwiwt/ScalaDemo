package leetCode

object Solution_955 {
  def minDeletionSize(strs: Array[String]): Int = {
    val arr = Array.fill(strs.length)(false)
    var res = 0
    strs.head.indices.foreach(i => {
      var flag = true
      strs.indices.drop(1).foreach(j => if (!arr(j) && strs(j - 1)(i) > strs(j)(i)) flag = false)
      if (!flag) res += 1
      else strs.indices.drop(1).foreach(j => if (!arr(j) && strs(j - 1)(i) < strs(j)(i)) arr(j) = true)
    })
    res
  }
}
