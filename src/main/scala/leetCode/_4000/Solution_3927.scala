package leetCode._4000

object Solution_3927 {
  private val MX = 100001

  private val divisors: Array[List[Int]] = {
    val ds = Array.fill(MX)(List.empty[Int])

    (1 until MX).foreach(d => (d until MX by d).foreach(x => ds(x) = d :: ds(x)))

    ds.map(_.reverse)
  }

  def minArraySum(nums: Array[Int]): Long = {
    val cnt = nums.groupBy(identity).mapValues(_.length.toLong)

    cnt.iterator.map { case (x, c) => divisors(x).find(cnt.contains).get.toLong * c }.sum
  }
}
