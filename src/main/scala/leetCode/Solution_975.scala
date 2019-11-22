package leetCode

import scala.collection.mutable

object Solution_975 {

  case class Jump(idx: Int, parity: Int)

  private val m = mutable.HashMap[Jump, Int]()

  def make(B: Array[Int]): Array[Option[Int]] = {
    val res: Array[Option[Int]] = Array.ofDim[Option[Int]](B.length).map(_ => None)
    var list = List[Int]()
    B.foreach(i => {
      while (list.nonEmpty && i > list.head) {
        res(list.head) = Some(i)
        list = list.tail
      }
      list = i :: list
    })
    res
  }

  def oddEvenJumps(A: Array[Int]): Int = {
    val incA = A.zipWithIndex.sortBy(x => x._1).map(_._2)
    val decA = A.zipWithIndex.sortBy(x => -x._1).map(_._2)
    val oddNext = make(incA)
    val evenNext = make(decA)
    val odd = Array.ofDim[Boolean](A.length)
    val even = Array.ofDim[Boolean](A.length)
    odd(A.length - 1) = true
    even(A.length - 1) = true
    (0 to A.length - 2).toList.reverse.foreach(i => {
      if (oddNext(i).nonEmpty) odd(i) = even(oddNext(i).get)
      if (evenNext(i).nonEmpty) even(i) = odd(evenNext(i).get)
    })
    odd.count(_ == true)
  }

  def sf(A: Array[Int]): Int = {
    val ans = if (A.isEmpty) 0 else A.indices.map(i => sf(A, i, 1)).sum
    m.clear
    ans
  }

  def sf(A: Array[Int], idx: Int, parity: Int): Int = {
    val newJump = Jump(idx, parity)
    if (m.contains(newJump)) m(newJump)
    if (idx == A.length - 1) 1
    else {
      val ans = parity match {
        case 0 => if (evenJump(A, idx).isEmpty) 0 else sf(A, evenJump(A, idx).get, 1)
        case 1 => if (oddJump(A, idx).isEmpty) 0 else sf(A, oddJump(A, idx).get, 0)
      }
      m(newJump) = ans
      ans
    }
  }

  def evenJump(A: Array[Int], idx: Int): Option[Int] = {
    val c = A.zipWithIndex.filter(x => x._1 <= A(idx) && x._2 > idx)
    if (c.isEmpty) None else Option(c.sortBy(x => (-x._1, x._2)).array(0)._2)
  }

  def oddJump(A: Array[Int], idx: Int): Option[Int] = {
    val c = A.zipWithIndex.filter(x => x._1 >= A(idx) && x._2 > idx)
    if (c.isEmpty) None else Option(c.sortBy(x => (x._1, x._2)).array(0)._2)
  }


  def lowerBound(xs: Array[Int], x: Int): Int = {

    @scala.annotation.tailrec
    def loop(first: Int, count: Int): Int = {
      if (count == 0) first
      else {
        val step = count / 2
        if (xs(first + step) < x) loop(first + step + 1, count - step - 1)
        else loop(first, step)
      }
    }

    loop(0, xs.length)
  }

  def upperBound(xs: Array[Int], x: Int): Int = {
    @scala.annotation.tailrec
    def loop(first: Int, count: Int): Int = {
      if (count == 0) first
      else {
        val step = count / 2
        if (x < xs(first + step)) loop(first, step)
        else loop(first + step + 1, count - step - 1)
      }
    }

    loop(0, xs.length)
  }

}
