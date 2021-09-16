package leetCode

object Solution_1996 {
  def numberOfWeakCharacters(properties: Array[Array[Int]]): Int = {
    var res = 0
    var mx = 0
    val p = properties.sortWith((a, b) => a.head > b.head || (a.head == b.head && a(1) < b(1)))
    p.indices.foreach(a => {
      if (p(a)(1) < mx) res += 1
      mx = mx.max(p(a)(1))
    })
    res
  }
}
