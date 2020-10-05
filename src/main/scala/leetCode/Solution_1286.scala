package leetCode

import scala.collection.mutable

object Solution_1286 {

  class CombinationIterator(_characters: String, _combinationLength: Int) {

    def buildCombination(pos: Int, sb: StringBuilder, output: mutable.ArrayBuffer[String]): Unit = {
      (pos to _characters.length - _combinationLength + sb.length()).foreach(i => {
        sb += _characters(i)
        if (sb.length() == _combinationLength) output += sb.toString
        else buildCombination(i + 1, sb, output)
        sb.setLength(sb.length() - 1)
      })
    }

    val combinations: Array[String] = {
      val output = new mutable.ArrayBuffer[String]
      buildCombination(0, new StringBuilder, output)
      output.toArray
    }

    var curr: Int = 0

    def next(): String = {
      curr += 1
      combinations(curr - 1)
    }

    def hasNext(): Boolean = curr < combinations.length

  }

}
