package leetCode

object Solution_418 {
  def wordsTyping(sentence: Array[String], rows: Int, cols: Int): Int = {
    val dp = Array.fill(sentence.length)(0)
    val next = Array.fill(sentence.length)(0)
    sentence.indices.foreach(i => {
      var cnt = 0
      var ptr = i
      var cur = cols
      while (cur >= sentence(ptr).length) {
        cur -= sentence(ptr).length + 1
        ptr += 1
        if (ptr == sentence.length) {
          cnt += 1
          ptr = 0
        }
      }
      dp(i) = cnt
      next(i) = ptr
    })
    var cnt = 0
    var cur = 0
    (0 until rows).foreach(_ => {
      cnt += dp(cur)
      cur = next(cur)
    })
    cnt
  }
}
