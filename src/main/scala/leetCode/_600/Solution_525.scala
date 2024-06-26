package leetCode._600

object Solution_525 {

  private case class State(sum: Int, m: Map[Int, Int])

  private def step(i: (Int, Int))(s: State): (State, Option[Int]) = {
    val newSum = if (i._1 == 1) s.sum + 1 else s.sum - 1
    s.m.get(newSum) match {
      case None => (State(newSum, s.m + (newSum -> i._2)), None)
      case Some(j) => (State(newSum, s.m), Some(i._2 - j))
    }
  }

  private case class MyState[A](runS: State => (State, A))

  private def next(i: (Int, Int)): MyState[Option[Int]] =
    MyState(step(i)(_))

  private def traverse(l: List[(Int, Int)]): MyState[List[Option[Int]]] = l match {
    case Nil => MyState((_, Nil))
    case x :: xs => MyState(s => {
      val (s1, o1) = next(x).runS(s)
      val (s2, os) = traverse(xs).runS(s1)
      (s2, o1 :: os)
    })
  }

  def findMaxLength(nums: Array[Int]): Int = {
    val (_, l) = traverse(nums.toList.zipWithIndex).runS(State(0, Map(0 -> -1)))
    l./:(0) { case (acc, x) =>
      x match {
        case None => acc
        case Some(v) => if (v > acc) v else acc
      }
    }
  }

}
