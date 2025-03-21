package leetCode._3500

import scala.collection.mutable

object Solution_3484 {
  class Spreadsheet(_rows: Int) {
    private val data: mutable.Map[String, Int] = mutable.Map()

    def setCell(cell: String, value: Int): Unit =
      data(cell) = value

    def resetCell(cell: String): Unit =
      data -= cell

    def getValue(formula: String): Int = {
      var res = 0
      formula.drop(1).split("\\+").foreach(cell => if (cell.head.isUpper) res += data.getOrElse(cell, 0) else res += cell.toInt)
      res
    }
  }
}
