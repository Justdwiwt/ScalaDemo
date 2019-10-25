package leetCode

object Solution_345 {
  def reverseVowels(s: String): String = {
    val str = s.toCharArray
    var pLeft = 0
    var pRight = str.length - 1
    while (pLeft < pRight) {
      if (isVowel(str(pLeft)) && isVowel(str(pRight))) {
        val tmp = str(pLeft)
        str(pLeft) = str(pRight)
        str(pRight) = tmp
        pLeft += 1
        pRight -= 1
      }
      else if (isVowel(str(pLeft))) pRight -= 1
      else pLeft += 1
    }
    String.valueOf(str)
  }

  def isVowel(c: Char): Boolean = {
    c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
  }
}
