package leetCode._2500

object Solution_2408 {
  class SQL(names: List[String], columns: List[Int]) {

    private var d: Map[String, List[List[String]]] =
      names.map(_ -> List.empty[List[String]]).toMap

    def insertRow(name: String, row: List[String]): Unit =
      d += name -> (d(name) :+ row)

    def deleteRow(name: String, rowId: Int): Unit =
      d += name -> d(name).updated(rowId - 1, null)

    def selectCell(name: String, rowId: Int, columnId: Int): String =
      d(name)(rowId - 1)(columnId - 1)
  }
}
