package leetCode._1900

object Solution_1858 {
  private var res: String = _

  def longestWord(words: Array[String]): String = {
    val root = new Trie()
    words.foreach(word => {
      var cur = root
      word.indices.foreach(i => {
        val j = word.charAt(i) - 'a'
        if (cur.children(j) == null)
          cur.children(j) = new Trie()
        cur = cur.children(j)
      })
      cur.isWord = true
    })

    res = ""
    dfs(root, new StringBuilder())
    res
  }

  private def dfs(trie: Trie, sb: StringBuilder): Unit = {
    var hasNext = false
    (0 until 26).foreach(i => {
      val child = trie.children(i)
      if (child != null && child.isWord) {
        hasNext = true
        sb.append(('a' + i).toChar)
        dfs(child, sb)
        sb.deleteCharAt(sb.length - 1)
      }
    })
    if (!hasNext && sb.length > res.length)
      res = sb.toString
  }

  class Trie {
    val children: Array[Trie] = Array.fill(26)(null)
    var isWord: Boolean = false
  }
}
