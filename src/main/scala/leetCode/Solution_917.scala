package leetCode

import java.util

object Solution_917 {
  def reverseOnlyLetters(S: String): String = {
    val letters: util.Stack[Character] = new util.Stack()
    val res: StringBuilder = new StringBuilder
    S.toCharArray
      .foreach(c => if (Character.isLetter(c)) letters.push(c))
    S.toCharArray
      .foreach(c => if (Character.isLetter(c)) res.append(letters.pop())
      else res.append(c))
    res.toString
  }
}
