package leetCode

object Solution_1208 {
  def equalSubstring(s: String, t: String, maxCost: Int): Int = {
    var res = 0
    var tmp = 0
    var pre = 0
    var diff = Array.empty[Int]
    s.indices.foreach(i => diff :+= (s(i) - t(i)).abs)
    s.indices.foreach(i => {
      tmp += diff(i)
      while (tmp > maxCost) {
        tmp -= diff(pre)
        pre += 1
        res = res.max(i - pre + 1)
      }
    })
    res
  }
}
