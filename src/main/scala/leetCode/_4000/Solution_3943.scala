package leetCode._4000

import scala.collection.mutable

object Solution_3943 {
  def numberOfPairs(nums1: Array[Int], nums2: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val B = 1.max(math.sqrt(nums1.length.toDouble * nums2.length).toInt)
    val MX = 1000000001

    case class Block(l: Int, r: Int, cnt: mutable.HashMap[Int, Int], var add: Int)

    val blocks = mutable.ArrayBuffer[Block]()

    var i = 0
    while (i < nums2.length) {
      val r = nums2.length.min(i + B)
      val cnt = mutable.HashMap[Int, Int]()
      var j = i
      while (j < r) {
        cnt(nums2(j)) = cnt.getOrElse(nums2(j), 0) + 1
        j += 1
      }
      blocks += Block(i, r, cnt, 0)
      i += B
    }

    val ans = mutable.ArrayBuffer[Int]()

    queries.foreach(q => if (q(0) == 1) {
      val l = q(1)
      val r = q(2) + 1
      val v = q(3)

      var k = 0
      while (k < blocks.length) {
        val b = blocks(k)

        if (b.l >= r) k = blocks.length
        else if (b.r <= l || b.add >= MX) k += 1
        else if (l <= b.l && b.r <= r) {
          b.add += v
          k += 1
        } else {
          var j = l.max(b.l)
          val end = r.min(b.r)

          while (j < end) {
            b.cnt(nums2(j)) -= 1

            nums2(j) = MX.min(nums2(j) + v)

            b.cnt(nums2(j)) = b.cnt.getOrElse(nums2(j), 0) + 1

            j += 1
          }
          k += 1
        }
      }

    } else {
      var res = 0
      blocks.foreach(b => {
        val target = q(1) - b.add
        nums1.foreach(x => res += b.cnt.getOrElse(target - x, 0))
      })
      ans += res
    })

    ans.toArray
  }
}
