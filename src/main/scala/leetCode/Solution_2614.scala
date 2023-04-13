package leetCode

object Solution_2614 {
  def diagonalPrime(nums: Array[Array[Int]]): Int = {
    def f(n: Int): Boolean = {
      if (n <= 2 || n % 2 == 0) return n == 2
      (3 to math.sqrt(n).toInt by 2).foreach(i => if (n % i == 0) return false)
      true
    }

    val da = nums.indices./:(0)((acc, i) => {
      if (f(nums(i)(i))) acc.max(nums(i)(i))
      else acc
    })
    nums.indices./:(da)((acc, i) => {
      if (f(nums(nums.length - i - 1)(i))) acc.max(nums(nums.length - i - 1)(i))
      else acc
    })
  }
}
