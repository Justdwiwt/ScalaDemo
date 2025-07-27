package leetCode._3600

object Solution_3599 {
  def minXor(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val INF = Int.MaxValue
    val init = Vector(0) ++ Vector.fill(n)(INF)

    def nextDP(prev: Vector[Int], i: Int): Vector[Int] =
      (0 to n).toVector.map(j => {
        if (j < i || j > n - (k - i)) INF
        else
          (j - 1 to i - 1 by -1).foldLeft((0, INF)) {
            case ((s, res), l) =>
              val s1 = s ^ nums(l)
              val res1 = math.min(res, math.max(prev(l), s1))
              (s1, res1)
          }._2
      })

    (1 to k).foldLeft(init)(nextDP)(n)
  }
}
