package leetCode

object Solution_1696 {
  def maxResult(nums: Array[Int], k: Int): Int = {
    val list = new java.util.LinkedList[Int]
    list.add(0)
    val dp = Array.fill(nums.length)(0)
    dp(0) = nums.head
    nums.indices.drop(1).foreach(i => {
      if (i - list.peekFirst() > k) list.removeFirst()
      dp(i) = dp(list.peekFirst()) + nums(i)
      while (!list.isEmpty && dp(list.peekLast()) <= dp(i)) list.removeLast()
      list.add(i)
    })
    dp(nums.length - 1)
  }
}
