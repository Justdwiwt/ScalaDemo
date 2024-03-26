package leetCode._1500

object Solution_1418 {
  def displayTable(orders: List[List[String]]): List[List[String]] = {
    val m = orders
      .map { case List(_, table, food) => (table, food) -> 1 }
      .groupBy(_._1)
      .map { case (key, items) => key -> items.length }
      .withDefaultValue(0)

    val (tables, foods) = orders.map { case List(_, table, food) => (table, food) }.unzip
    val tab = tables.distinct.map(_.toInt).sorted.map(_.toString)
    val foo = foods.distinct.sorted
    ("Table" :: foo) :: tab.map(t => t :: foo.map(f => m((t, f)).toString))
  }
}
