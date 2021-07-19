package leetCode

import scala.util.control.Breaks._

object Solution_1935 {
  def canBeTypedWords(text: String, brokenLetters: String): Int = {
    val st = brokenLetters.toCharArray.toSet
    text.split(" ").count(x => {
      var flag = true
      breakable(x.toCharArray.foreach(c => {
        if (st.contains(c)) {
          flag = false
          break()
        }
      }))
      flag
    })
  }
}

