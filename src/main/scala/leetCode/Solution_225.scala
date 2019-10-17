package leetCode

import scala.collection.mutable

class Solution_225 {

  var q1: mutable.Queue[Int] = mutable.Queue[Int]()
  var q2: mutable.Queue[Int] = mutable.Queue[Int]()


  def push(x: Int): Unit = {
    q1.enqueue(x)
  }

  def pop(): Int = {
    val res = top()
    q1.dequeue()
    res
  }

  def top(): Int = {
    if (empty()) throw new Error("stack is empty")
    if (q1.isEmpty) {
      val t = Tuple2(q1, q2)
      val tmp = t.swap
      q1 = tmp._1
      q2 = tmp._2
    }
    while (q1.length > 1) {
      q2.enqueue(q1.front)
      q1.dequeue()
    }
    q1.front
  }

  def empty(): Boolean = {
    q1.isEmpty && q2.isEmpty
  }

}
