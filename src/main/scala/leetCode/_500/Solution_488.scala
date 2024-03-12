package leetCode._500

import scala.collection.immutable

object Solution_488 {
  val colors: Map[Char, Int] = "RYBGW".zipWithIndex.toMap

  case class Balls(color: Int, qnt: Int = 1, separable: Boolean = false)

  case class State(board: Seq[Balls], hand: Array[Int])

  def findMinStep(board: String, hand: String): Int = {
    val h = Array.ofDim[Int](5)
    hand.foreach(c => h(colors(c)) += 1)
    val b = board./:(Seq.empty[Balls]) {
      case (in :+ Balls(lc, q, _), c) if lc == colors(c) => in :+ Balls(lc, q + 1, separable = true)
      case (s, c) => s :+ Balls(colors(c), separable = true)
    }

    helper(Seq(State(b, h)), 0)
  }

  @scala.annotation.tailrec
  def helper(q: Seq[State], res: Int): Int = {
    if (q.exists(_.board.isEmpty)) res
    else if (q.isEmpty) -1
    else {
      val newQ = q.flatMap(state => state.board.indices.flatMap(i => getStatesWithSeparatedPair(state, i) ++ getStateWithInsertedBall(state, i)))
      helper(newQ, res + 1)
    }
  }

  def getStatesWithSeparatedPair(state: State, i: Int): immutable.Seq[State] = {
    val balls = state.board(i)
    if (balls.qnt > 1 && balls.separable)
      state.hand.indices.flatMap(c => {
        if (state.hand(c) > 0 && c != balls.color)
          Some(State((state.board.take(i) :+ Balls(balls.color) :+ Balls(c) :+ Balls(balls.color)) ++ state.board.drop(i + 1), getNewHand(state.hand, c)))
        else None
      })
    else Nil
  }

  def getStateWithInsertedBall(state: State, i: Int): Seq[State] = {
    val balls = state.board(i)
    if (state.hand(balls.color) > 0)
      Seq(State(inserted((state.board.take(i) :+ Balls(balls.color, balls.qnt + 1)) ++ state.board.drop(i + 1), i), getNewHand(state.hand, balls.color)))
    else Nil
  }

  @scala.annotation.tailrec
  def inserted(board: Seq[Balls], p: Int): Seq[Balls] = board(p) match {
    case Balls(_, q, _) if q > 2 =>
      val init = board.take(p)
      val tail = board.drop(p + 1)
      (init.lastOption, tail.headOption) match {
        case (Some(x), Some(y)) if x.color == y.color => inserted((init.init :+ Balls(x.color, x.qnt + y.qnt)) ++ tail.tail, p - 1)
        case _ => init ++ tail
      }
    case _ => board
  }

  def getNewHand(hand: Array[Int], c: Int): Array[Int] = {
    val res = hand
    res(c) -= 1
    res
  }
}
