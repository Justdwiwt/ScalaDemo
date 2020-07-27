package leetCode

object Solution_1209 {
  def removeDuplicates(s: String, k: Int): String = {
    var cnt = 1
    (1 until s.length).foreach(i => {
      if (s(i) == s(i - 1)) cnt += 1
      else cnt = 1
      if (cnt == k)
        return removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k)
    })
    s
  }
}
