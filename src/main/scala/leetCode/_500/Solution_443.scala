package leetCode._500

object Solution_443 {
  def compress(chars: Array[Char]): Int = {
    var res = ""
    var cnt = 0
    chars.indices.foreach(i => {
      cnt += 1
      if (i == (chars.length - 1) || chars(i) != chars(i + 1)) {
        res += chars(i)
        if (cnt > 1) res += cnt
        cnt = 0
      }
    })
    res.indices.foreach(i => chars(i) = res(i))
    res.length
  }
}
