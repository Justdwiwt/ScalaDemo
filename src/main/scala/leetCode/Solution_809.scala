package leetCode

object Solution_809 {

  case class Letter(ch: Char, rep: Int) {
    def isStretchy: Boolean = rep >= 3
  }

  def expressiveWords(s: String, words: Array[String]): Int = {
    val letters = parse(s)

    def isExpressive(word: String): Boolean = {
      var wordIndex = 0
      var lettersIndex = 0
      while (wordIndex < word.length && lettersIndex < letters.length) {
        if (word(wordIndex) != letters(lettersIndex).ch) return false
        else {
          val cnt = fastForward(word, wordIndex, letters(lettersIndex))
          wordIndex += cnt
          lettersIndex += 1
        }
      }
      wordIndex >= word.length && lettersIndex >= letters.length
    }

    words./:(0)((acc, word) => if (isExpressive(word)) acc + 1 else acc)
  }

  def parse(s: String): Array[Letter] = {
    val res = collection.mutable.ListBuffer.empty[Letter]
    var i = 0
    while (i < s.length) {
      val cnt = countChars(s, i)
      if (cnt >= 3) {
        res += Letter(s(i), cnt)
        i += cnt
      } else {
        res += Letter(s(i), 1)
        i += 1
      }
    }
    res.toArray
  }

  def countChars(s: String, idx: Int): Int = {
    val ch = s(idx)

    @scala.annotation.tailrec
    def count(i: Int, cnt: Int): Int =
      if (i >= s.length) cnt
      else if (s(i) != ch) cnt
      else count(i + 1, cnt + 1)

    count(idx, 0)
  }

  def fastForward(s: String, wordIndex: Int, letter: Letter): Int =
    if (letter.isStretchy) countChars(s, wordIndex).min(letter.rep)
    else 1

}
