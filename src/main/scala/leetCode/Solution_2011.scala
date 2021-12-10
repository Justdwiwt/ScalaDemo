package leetCode

object Solution_2011 {
  def finalValueAfterOperations(operations: Array[String]): Int = {
    operations.length - (2 * operations.count(_.contains("-")))
  }
}
