package leetCode

import scala.util.Random

object Solution_384 {

  class Solution(_nums: Array[Int]) {

    private var arr = _nums
    private var original = _nums.clone()

    val rand = new Random()

    def randRange(min: Int, max: Int): Int = rand.nextInt(max - min) + min

    def reset(): Array[Int] = {
      arr = original
      original = original.clone()
      original
    }

    def shuffle(): Array[Int] = {
      arr.indices.foreach(i => swap(i, randRange(i, arr.length)))
      arr
    }

    def swap(index1: Int, index2: Int): Unit = {
      val t = arr(index1)
      arr(index1) = arr(index2)
      arr(index2) = t
    }

  }

}
