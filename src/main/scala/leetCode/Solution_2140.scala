package leetCode

import scala.collection.mutable

object Solution_2140 {
  def mostPoints(questions: Array[Array[Int]]): Long = {
    val m = mutable.Map.empty[Int, Long]

    def f(idx: Int): Long = m.getOrElseUpdate(idx, {
      if (idx >= questions.length) 0
      else {
        val Array(points, brainpower) = questions(idx)
        f(idx + 1).max(points + f(idx + brainpower + 1))
      }
    })

    f(idx = 0)
  }
}
