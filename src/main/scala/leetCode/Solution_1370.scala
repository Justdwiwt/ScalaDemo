package leetCode

object Solution_1370 {
  def sortString(s: String): String = {
    val arr = Array.fill(26)(0)
    s.indices.foreach(i => arr(s(i) - 'a') += 1)
    var res = ""
    while (res.length < s.length) {
      (0 until 26).foreach(i => {
        if (arr(i) > 0) {
          res += (i + 'a').toChar
          arr(i) -= 1
        }
      })
      (0 until 26).reverse.foreach(i => {
        if (arr(i) > 0) {
          res += (i + 'a').toChar
          arr(i) -= 1
        }
      })
    }
    res
  }
}
