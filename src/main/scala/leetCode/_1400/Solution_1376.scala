package leetCode._1400

object Solution_1376 {
  def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(x: Int, acc: Int = 0): Int = if (x == headID) acc + informTime(x) else f(manager(x), informTime(x) + acc)

    (0 until n).withFilter(x => informTime(x) == 0).map(x => f(x)).max
  }
}
