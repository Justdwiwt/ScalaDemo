package leetCode._400

object Solution_354 {
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    val sorted = envelopes.sortBy(_.head)
    val length = envelopes.length
    if (length < 2) length
    else {
      val res = envelopes.indices.dropRight(1).reverse./:(Map(length - 1 -> 1))((acc, i) => {
        val e = sorted(i)
        val cur = acc./:(1)((ac, ee) => {
          val w = sorted(ee._1).head
          val h = sorted(ee._1)(1)
          if (w > e.head && h > e(1)) ac.max(ee._2 + 1)
          else ac
        })
        acc + (i -> cur)
      })
      res.values.max
    }
  }
}
