package leetCode

object Solution_1078 {
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ")
    (words, words.tail, words.tail.tail).zipped.collect({ case (w1, w2, w3) if w1 == first && w2 == second => w3 }).toArray
  }
}
