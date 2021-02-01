package leetCode

import scala.collection.mutable

object Solution_456 {
  def find132pattern(nums: Array[Int]): Boolean = {
    if (nums.length < 3) return false
    val mn = nums.scanLeft(Int.MaxValue)(_.min(_)).tail
    val stack = mutable.Stack[Int]()
    nums.indices.reverse.withFilter(j => nums(j) > mn(j)).foreach(j => {
      while (stack.nonEmpty && stack.top <= mn(j)) stack.pop()
      if (stack.nonEmpty && stack.top < nums(j)) return true
      stack.push(nums(j))
    })
    false
  }
}
