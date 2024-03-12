package leetCode._2800

object Solution_2748 {
  def countBeautifulPairs(nums: Array[Int]): Int = {
    var cnt = 0
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => if (f(nums(i).toString.head.toString.toInt, nums(j) % 10)) cnt += 1))
    cnt
  }

  private def f(i: Int, j: Int): Boolean = (2 to i)
    .forall(k => (i % k != 0) || (j % k != 0))
}
