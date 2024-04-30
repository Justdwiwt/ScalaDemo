package leetCode._1300

import scala.collection.mutable

object Solution_1273 {
  // fixme: case 20/21 stack overflow
  def deleteTreeNodes(nodes: Int, parent: Array[Int], value: Array[Int]): Int = {
    val child = mutable.Map[Int, Array[Int]]().withDefaultValue(Array.emptyIntArray)

    parent.zipWithIndex.foreach { case (par, idx) => child(par) = child(par) :+ idx }

    def f(i: Int): (Int, Int) = {
      var count = 1
      var sum = value(i)

      child(i).foreach(c => {
        val (tc, tv) = f(c)
        count += tc
        sum += tv
      })

      if (sum != 0) (count, sum) else (0, 0)
    }

    f(0)._1
  }
}
