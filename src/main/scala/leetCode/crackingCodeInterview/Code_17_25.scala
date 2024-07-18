package leetCode.crackingCodeInterview

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

// fixme: case 4/34 wrong answer
object Code_17_25 {
  def maxRectangle(words: Array[String]): Array[String] = {
    val tm = mutable.TreeMap.empty[Int, mutable.TreeSet[String]]
    words.foreach(word => tm.getOrElseUpdate(word.length, mutable.TreeSet[String]()).add(word))

    val list = tm.keySet.toList
    val pairs = ArrayBuffer.empty[Array[Int]]
    list.indices.foreach(i => (i until list.size).foreach(j => pairs += Array(list(i), list(j))))

    pairs.sortBy(pair => -pair.head * pair(1))

    var res: Array[String] = null
    breakable {
      pairs.foreach(pair => {
        val m = pair.head
        val n = pair(1)
        val matrix = Array.fill(m)("")

        if (backtrack(matrix, 0, tm.getOrElse(n, mutable.TreeSet[String]()), tm.getOrElse(m, mutable.TreeSet[String]()))) {
          res = matrix
          break
        }
      })
    }
    res
  }

  private def backtrack(matrix: Array[String], r: Int, rowWords: mutable.TreeSet[String], colWords: mutable.TreeSet[String]): Boolean = {
    if (r == matrix.length) return true

    var found = false
    breakable {
      rowWords.foreach(word => {
        matrix(r) = word
        if (valid(matrix, r, colWords))
          if (backtrack(matrix, r + 1, rowWords, colWords)) {
            found = true
            break
          }
      })
    }
    found
  }

  private def valid(matrix: Array[String], r: Int, colWords: mutable.TreeSet[String]): Boolean = {
    val n = matrix.head.length
    var isValid = true
    breakable {
      (0 until n).foreach(j => {
        val sb = new StringBuilder()
        for (i <- 0 to r) sb.append(matrix(i)(j))
        if (colWords.range(sb.toString(), sb.append('{').toString()).isEmpty) {
          isValid = false
          break
        }
      })
    }
    isValid
  }
}
