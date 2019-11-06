package leetCode

object Solution_1189 {
  def maxNumberOfBalloons(text: String): Int = {
    val arr = new Array[Int](26)
    text.toCharArray.foreach(i => arr(i - 97) += 1)
    arr('l' - 97) /= 2
    arr('o' - 97) /= 2
    var res = Int.MaxValue
    "balon".toCharArray.foreach(i => if (arr(i - 97) < res) res = arr(i - 97))
    res
  }
}
