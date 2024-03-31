package leetCode._1000

object Solution_960 {
  def minDeletionSize(A: Array[String]): Int = {
    val dp = Array.fill(A.head.length)(1)
    A.head.indices.foreach(i => (0 until i).foreach(j => if (A.forall(k => k(j) <= k(i))) dp(i) = dp(i).max(dp(j) + 1)))
    A.head.length - dp.max
  }

  def func(arr: Array[Array[Int]]): Int = {
    val A = arr.map(_.max)
    val B = arr.head.indices.toArray.map(j => arr.indices.map(arr(_)(j)).max)
    val d = arr.indices.flatMap(i => arr(i).indices.map(j => A(i).min(B(j)) - arr(i)(j)))
    d.sum
  }
}
