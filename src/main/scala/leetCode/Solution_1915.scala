package leetCode

object Solution_1915 {
  def wonderfulSubstrings(word: String): Long = {
    val arr = Array.fill(1 << ('j' - 'a' + 1))(0)
    arr(0) = 1
    var t = 0
    var res = 0L
    word.foreach(c => {
      t ^= (1 << (c - 'a'))
      res += arr(t)
      ('a' to 'j').foreach(other => res += arr(t ^ (1 << (other - 'a'))))
      arr(t) += 1
    })
    res
  }
}
