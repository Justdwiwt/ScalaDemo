package leetCode

object Solution_1255 {
  def maxScoreWords(words: Array[String], letters: Array[Char], score: Array[Int]): Int = {

    def createCounter(letters: String): Array[Int] = letters./:(Array.fill(26)(0))((acc, x) => {
      acc(x - 97) += 1
      acc
    })

    def canBeCreated(x1: Array[Int], x2: Array[Int]): Boolean = x1.zip(x2)./:(true)((res, x) => {
      if (x._1 < x._2) false
      else res
    })

    val lettersCounter = createCounter(letters.mkString)

    var combinations = Array[String]("")

    words.indices.foreach(x => {
      combinations = combinations.flatMap(y => {
        if (canBeCreated(lettersCounter, createCounter(y + words(x)))) Array(y, y + words(x))
        else Array(y)
      })
    })

    combinations./:(0)((mx, x) => mx.max(x./:(0)((acc, y) => acc + score(y - 97))))
  }
}
