package leetCode

object Solution_108 {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    def f(nums: Array[Int], l: Int, r: Int): TreeNode = {
      if (l > r) return null
      val m = (l + r) / 2
      val root = new TreeNode(nums(m))
      root.left = f(nums, l, m - 1)
      root.right = f(nums, m + 1, r)
      root
    }

    f(nums, 0, nums.length - 1)
  }
}
