package leetCode

object Solution_1042 {
  def gardenNoAdj(N: Int, paths: Array[Array[Int]]): Array[Int] = {
    val res = Array.fill(N)(0)
    val t = Array.fill(N)(List.empty[Int])
    paths.foreach({
      case Array(x, y) =>
        t(x - 1) ::= y - 1
        t(y - 1) ::= x - 1
    })
    (0 until N).foreach(i => {
      var s = Set(1, 2, 3, 4)
      t(i).foreach(j => s -= res(j))
      res(i) = s.toList.head
    })
    res
  }
}
