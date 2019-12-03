package leetCode

object Solution_1160 {
  def countCharacters(words: Array[String], chars: String): Int = {
    val table = Array.fill(26)(0)
    chars.indices.foreach(i => table(chars(i) - 'a') += 1)
    var cnt = 0
    words.filter(i => visited(i, table)).foreach(i => cnt += i.length)
    cnt
  }

  def visited(str: String, table: Array[Int]): Boolean = {
    val tmp = Array.fill(26)(0)
    str.indices.foreach(i => {
      val now = str(i)
      if (tmp(now - 'a') == table(now - 'a')) return false
      tmp(now - 'a') += 1
    })
    true
  }
}
