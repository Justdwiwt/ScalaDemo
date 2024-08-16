package leetCode._3200

import scala.util.control.Breaks._

object Solution_3117 {
  def minimumValueSum(nums: Array[Int], andValues: Array[Int]): Int = {
    val INF = Int.MaxValue / 2
    val n = nums.length
    var arr = Array.fill(n + 1)(INF)
    arr(0) = 0
    var newF = Array.fill(n + 1)(INF)
    val q = Array.fill(n + 1)(0)

    andValues.foreach(target => {
      val a = nums.clone()
      var left, right = 0
      var ql, qr, qi = 0

      newF(0) = INF
      nums.indices.foreach(i => {
        var x = a(i)

        breakable((0 until i).reverse.foreach(j => {
          if ((a(j) & x) == a(j)) break()
          a(j) &= x
        }))

        while (left <= i && a(left) < target) left += 1

        while (right <= i && a(right) <= target) right += 1

        if (left < right) {
          while (qi < right) {
            while (qr > ql && arr(q(qr - 1)) >= arr(qi)) qr -= 1
            q(qr) = qi
            qr += 1
            qi += 1
          }

          while (ql < qr && q(ql) < left) ql += 1

          newF(i + 1) = arr(q(ql)) + x
        } else newF(i + 1) = INF
      })

      val temp = arr
      arr = newF
      newF = temp
    })

    if (arr(n) < INF) arr(n) else -1
  }
}
