package leetCode._100

object Solution_59 {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    @scala.annotation.tailrec
    def f(list: List[List[Int]], idx: Int): List[List[Int]] = idx match {
      case i if i == 1 => list
      case i =>
        val t = List.range(i - list.head.length, i)
        i - list.head.length match {
          case k if k != 1 => f((t :: list).transpose.map(_.reverse), k)
          case k => f(t :: list, k)
        }
    }

    f(List(List(n * n)), n * n).map(_.toArray).toArray
  }
}
