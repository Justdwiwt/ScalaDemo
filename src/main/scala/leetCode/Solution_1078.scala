package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_1078 {
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val word = text.split(" ")
    val res = new ArrayBuffer[String]()
    (0 until word.length - 2).foreach(i => if (word(i).equals(first) && word(i + 1).equals(second)) res.append(word(i + 2)))
    res.toArray
  }
}
