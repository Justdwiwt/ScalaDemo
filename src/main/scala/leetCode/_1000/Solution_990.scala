package leetCode._1000

object Solution_990 {
  def equationsPossible(equations: Array[String]): Boolean = {
    val data = Array.tabulate('z' - 'a' + 1)(identity)
    equations.filter(_ (1) == '=').foreach(e => data(f(data, e.last - 'a')) = f(data, e.head - 'a'))
    equations.filter(_ (1) == '!').forall(e => f(data, e.head - 'a') != f(data, e.last - 'a'))
  }

  @scala.annotation.tailrec
  def f(data: Array[Int], i: Int): Int = if (data(i) == i) i else f(data, data(i))
}
