package leetCode._3300

object Solution_3300 {
  def minElement(nums: Array[Int]): Int = {
    def digitSum(x: Int): Int = {
      @scala.annotation.tailrec
      def f(n: Int, acc: Int = 0): Int = {
        if (n == 0) acc
        else f(n / 10, acc + n % 10)
      }

      f(x)
    }

    nums.map(digitSum).min
  }
}
