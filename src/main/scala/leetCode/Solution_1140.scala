package leetCode

import scala.collection.mutable

object Solution_1140 {
  implicit class ArrayOps[T](val arr: Array[T]) extends AnyVal {

    def get(i: Int): Option[T] = if (0 <= i && i < arr.length) Some(arr(i)) else None

    def getOrElse(i: Int, v: => T): T = get(i).getOrElse(v)
  }

  case class State(i: Int, m: Int)

  class Solver(piles: Array[Int]) {

    def compute(s: State): Int = bare(s)

    final protected def bare(s: State): Int =
      if (s.i >= piles.length) 0
      else (1 to 2 * s.m).map(j => {
        val nextM = s.m.max(j)
        val next = (1 to 2 * nextM).map(k => compute(State(s.i + j + k, nextM.max(k)))).min
        (s.i until s.i + j).map(piles.getOrElse(_, 0)).sum + next
      }).max
  }

  final class SolverTab(piles: Array[Int], tab: mutable.Map[State, Int]) extends Solver(piles) {
    override def compute(s: State): Int = tab.getOrElse(s, {
      val res = bare(s)
      tab(s) = res
      res
    })
  }

  def stoneGameII(piles: Array[Int]): Int =
    new SolverTab(piles, mutable.Map.empty[State, Int]).compute(State(0, 1))
}
