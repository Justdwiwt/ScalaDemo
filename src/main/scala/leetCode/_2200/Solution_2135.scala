package leetCode._2200

object Solution_2135 {
  def wordCount(startWords: Array[String], targetWords: Array[String]): Int = {
    def f(word: String): Int =
      word.view.map(x => 1 << (x - 'a')).reduce(_ | _)

    val st = startWords.map(f).toSet
    targetWords.count(w => {
      val mask = f(w)
      ('a' to 'z').exists(c => {
        val bit = 1 << (c - 'a')
        (bit & mask) != 0 && st(mask - bit)
      })
    })
  }
}
