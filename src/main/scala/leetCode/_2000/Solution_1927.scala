package leetCode._2000

object Solution_1927 {
  def sumGame(num: String): Boolean = {
    var x = 0
    var y = 0
    var a = 0
    var b = 0
    (0 until num.length / 2).foreach(i => {
      if (num(i) == '?') a += 1
      else x += num(i) - '0'
    })
    (num.length / 2 until num.length).foreach(i => {
      if (num(i) == '?') b += 1
      else y += num(i) - '0'
    })
    (a + b) % 2 == 1 || (a - b) * 9 / 2 != y - x
  }
}
