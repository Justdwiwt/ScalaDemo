package leetCode._600

import scala.util.Random

object Solution_528 {

  class Solution(_w: Array[Int]) {

    private val arr = _w.scanLeft(0)(_ + _).tail

    def pickIndex(): Int = {
      val t = Random.nextInt(arr.last)
      arr.indexWhere(t < _)
    }
  }

}
