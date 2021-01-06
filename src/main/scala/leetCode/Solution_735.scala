package leetCode

object Solution_735 {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def f(arr: List[Int], ss: List[Int]): Array[Int] = (arr, ss) match {
      case (Nil, ss) => ss.reverse.toArray
      case (a :: tail, Nil) => f(tail, List(a))
      case (a :: tail, ss) if a > 0 || ss.head < 0 => f(tail, a :: ss)
      case (a :: tail, ss) if ss.head > -a => f(tail, ss)
      case (a :: tail, ss) if ss.head == -a => f(tail, ss.tail)
      case (_, ss) => f(arr, ss.tail)
    }

    f(asteroids.toList, Nil)
  }
}
