package leetCode._300

object Solution_291 {
  def wordPatternMatch(pattern: String, s: String): Boolean = {
    val string2Char = collection.mutable.Map.empty[String, Char]
    val char2String = collection.mutable.Map.empty[Char, String]

    def f(depth: Int, prev: Int): Boolean = {
      if (prev == s.length - 1 || depth == pattern.length) depth == pattern.length && prev == s.length - 1
      else {
        val c = pattern(depth)
        val charExists = char2String.isDefinedAt(c)
        val words =
          if (charExists) List(char2String(c))
          else (prev + 1 until s.length).map(next => s.substring(prev + 1, next + 1))
        words.exists(word => {
          val wordExists = string2Char.isDefinedAt(word)
          val next = prev + word.length
          if (charExists && char2String(c) != word) false
          else if (wordExists && string2Char(word) != c) false
          else if (next >= s.length || s.substring(prev + 1, next + 1) != word) false
          else {
            string2Char(word) = c
            char2String(c) = word
            val ans = f(depth + 1, next)
            if (!charExists) string2Char -= word
            if (!wordExists) char2String -= c
            ans
          }
        })
      }
    }

    f(0, -1)
  }
}
