package leetCode

object Solution_898 {
  def subarrayBitwiseORs(A: Array[Int]): Int = {
    if (A.length == 1) return 1
    var dp = Array.ofDim[Int](A.length)
    dp.indices.foreach(i => dp(i) = A(i))
    var res = Set[Int]()
    res ++= dp
    (2 to A.length).foreach(len => {
      val tmp = Array.ofDim[Int](A.length - len + 1)
      (0 to A.length - len).foreach(i => tmp(i) = dp(i) | A(i + len - 1))
      dp = tmp
      res ++= dp
    })
    res.size
  }
}
