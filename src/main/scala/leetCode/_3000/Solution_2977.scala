package leetCode._3000

import scala.collection.mutable

object Solution_2977 {
  def minimumCost(source: String, target: String, original: Array[String], changed: Array[String], cost: Array[Int]): Long = {
    val P = 131
    val M = 1e9.toInt + 7
    val n = original.length

    val map = mutable.Map.empty[Long, Int]
    val ori = Array.fill[Long](n)(0)
    val cha = Array.fill[Long](n)(0)

    original.indices.foreach(j => {
      var t = 0L
      original(j).indices.foreach(i => t = (t * P + original(j)(i)) % M)
      ori(j) = t
    })

    original.indices.foreach(j => {
      var t = 0L
      changed(j).indices.foreach(i => t = (t * P + changed(j)(i)) % M)
      cha(j) = t
    })

    var cnt = 0
    ori.indices.foreach(i => if (!map.contains(ori(i)))
      map(ori(i)) = {
        cnt += 1
        cnt - 1
      })

    cha.indices.foreach(i => if (!map.contains(cha(i)))
      map(cha(i)) = {
        cnt += 1
        cnt - 1
      })

    val g = Array.fill(cnt, cnt)(Int.MaxValue >> 1)

    original.indices.foreach(i => g(map(ori(i)))(map(cha(i))) = Math.min(g(map(ori(i)))(map(cha(i))), cost(i)))

    (0 until cnt).foreach(k => (0 until cnt).foreach(i => (0 until cnt).foreach(j => g(i)(j) = Math.min(g(i)(j), g(i)(k) + g(k)(j)))))

    val len = source.length
    val csou = source.toCharArray
    val ctar = target.toCharArray

    val dp = Array.fill[Long](len + 1)(Long.MaxValue)
    dp(0) = 0

    source.indices.foreach(i => {
      if (csou(i) == ctar(i)) dp(i + 1) = dp(i + 1).min(dp(i))

      var t = 0L
      var s = 0L
      (i until source.length).foreach(j => {
        t = (t * P + ctar(j)) % M
        s = (s * P + csou(j)) % M
        if (dp(i) != Long.MaxValue && map.contains(s) && map.contains(t) && g(map(s))(map(t)) < (Int.MaxValue >> 1))
          dp(j + 1) = dp(j + 1).min(dp(i) + g(map(s))(map(t)))
      })
    })
    if (dp(source.length) == Long.MaxValue) -1 else dp(source.length)
  }
}
