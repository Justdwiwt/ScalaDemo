package leetCode

object Solution_1458 {

  class Lazy[T](expr: => T) {
    lazy val value: T = expr

    def apply(): T = value
  }

  object Lazy {
    def apply[T](expr: => T) = new Lazy(expr)
  }

  def maxDotProduct(nums1: Array[Int], nums2: Array[Int]): Int = {
    val mx = nums1.flatMap(x => nums2.map(y => x * y)).max
    if (mx < 0) mx
    else {
      def f(i: Int, j: Int): Lazy[Int] = Lazy(
        if (i * j == 0) 0
        else (m(i - 1)(j - 1)() + nums1(i - 1) * nums2(j - 1)).max(m(i - 1)(j)()).max(m(i)(j - 1)()))

      lazy val m = Array.tabulate[Lazy[Int]](nums1.length + 1, nums2.length + 1)(f)
      f(nums1.length, nums2.length)()
    }
  }

}
