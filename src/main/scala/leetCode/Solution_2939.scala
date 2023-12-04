package leetCode

object Solution_2939 {
  def maximumXorProduct(_a: Long, _b: Long, n: Int): Int = {
    var M = (1e9 + 7).toInt
    var a = _a
    var b = _b
    if (b > a) {
      val t = a
      a = b
      b = t
    }

    var mask = (1L << n) - 1
    var ax = a & (~mask)
    var bx = b & (~mask)
    a &= mask
    b &= mask

    var left = a ^ b
    var one = mask ^ left

    ax |= one
    bx |= one

    if (left > 0 && ax == bx) {
      var l = java.lang.Long.highestOneBit(left)
      ax |= l
      left ^= l
    }

    bx |= left

    ax %= M
    bx %= M
    (ax * bx % M).toInt
  }
}
