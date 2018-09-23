package basic

object FirstDemo {
  def main(args: Array[String]): Unit = {
    print("SUCCESS")
  }

  var x = 5
  var x0 = 6
  var y = 6
  var y0 = 5

  private def sqrt(i: Int) = i

  //noinspection ScalaUnusedSymbol
  private val distance = {
    val dx = x - x0
    val dy = y - y0
    sqrt(dx * dx + dy * dy)
  }
}
