package leetCode.LCP

object LCP_33 {
  def storeWater(bucket: Array[Int], vat: Array[Int]): Int = {
    var mx = vat.head
    bucket.indices.foreach(i => mx = mx.max(vat(i)))
    if (mx == 0) return 0
    var res = Int.MaxValue
    (1 to mx).reverse.foreach(p => {
      var in = 0
      bucket.indices.foreach(i => {
        val need = if (vat(i) % p == 0) vat(i) / p else vat(i) / p + 1
        in += (if (need - bucket(i) >= 0) need - bucket(i) else 0)
      })
      res = res.min(in + p)
    })
    res
  }
}
