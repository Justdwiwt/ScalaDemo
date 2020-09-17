package leetCode

import scala.collection.mutable.ListBuffer

object Solution_996 {
  def numSquarefulPerms(A: Array[Int]): Int = {
    val res = ListBuffer[ListBuffer[Int]]()
    val visited = Array.ofDim[Boolean](A.length)
    f(res, ListBuffer[Int](), visited, A.sorted, -1)
    res.size
  }

  def f(res: ListBuffer[ListBuffer[Int]], path: ListBuffer[Int], vis: Array[Boolean], nums: Array[Int], prev: Int): Unit = {
    if (path.size == nums.length) res.append(path.clone())
    else nums.indices.foreach(i => {
      if (vis(i)) None
      else if (i > 0 && nums(i) == nums(i - 1) && !vis(i - 1)) None
      else if (prev != -1 && !isPerfectSquare(prev, nums(i))) None
      else {
        vis(i) = true
        path.append(nums(i))
        f(res, path, vis, nums, nums(i))
        path.remove(path.size - 1)
        vis(i) = false
      }
    })
  }

  def isPerfectSquare(x: Int, y: Int): Boolean = {
    val sr = math.sqrt(x + y)
    sr - math.floor(sr) == 0
  }
}
