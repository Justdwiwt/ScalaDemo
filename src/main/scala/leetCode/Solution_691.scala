package leetCode

import scala.collection.mutable

object Solution_691 {
  def minStickers(stickers: Array[String], target: String): Int = {
    val dp = Array.fill(1 << target.length)(-1)
    dp(0) = 0

    val table = mutable.Map.empty[String, Array[Int]]
    stickers.foreach(str => table(str) = chCount(str))

    def update(state: Int, x: String): Int = {
      var now = state
      val A = Array.fill(26)(0)
      (0 until 26).foreach(i => A(i) = table(x)(i))

      target.indices.map({ i =>
        val pos = target.length - i - 1
        (i, pos)
      }).withFilter {
        case (i, _) => (state & (1 << i)) == 0
      }.foreach({
        case (i, pos) => if (A(target(pos) - 'a') > 0) {
          A(target(pos) - 'a') -= 1
          now |= 1 << i
        }
      })
      now
    }

    (0 until 1 << target.length).foreach(state => if (dp(state) != -1) {
      stickers.foreach(x => {
        val now = update(state, x)
        if (dp(now) == -1 || dp(now) > dp(state) + 1) dp(now) = dp(state) + 1
      })
    })
    dp.last
  }

  def chCount(str: String): Array[Int] = {
    val res = Array.fill(26)(0)
    str.foreach(ch => res(ch - 'a') += 1)
    res
  }

}
