package leetCode._1700

object Solution_1691 {
  def maxHeight(cuboids: Array[Array[Int]]): Int = {
    val sorted = cuboids
    sorted.indices.foreach(i => java.util.Arrays.sort(sorted(i)))
    java.util.Arrays.sort(sorted, (o1: Array[Int], o2: Array[Int]) =>
      if (o1.head != o2.head) o1.head - o2.head
      else {
        if (o1(1) != o2(1)) o1(1) - o2(1)
        else o1(2) - o2(2)
      })
    val dp = Array.fill(cuboids.length)(0)
    var res = 0
    sorted.indices.foreach(i => {
      dp(i) = sorted(i)(2)
      (0 until i).foreach(j => if (sorted(i).head >= sorted(j).head && sorted(i)(1) >= sorted(j)(1) && sorted(i)(2) >= sorted(j)(2))
        dp(i) = dp(i).max(sorted(i)(2) + dp(j)))
      res = dp(i).max(res)
    })
    res
  }
}
