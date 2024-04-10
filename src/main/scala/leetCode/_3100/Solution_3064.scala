package leetCode._3100

object Solution_3064 {
  private def commonSetBits(n: Int): Int = ???

  def findNumber(): Int = {
    var res = 0
    var temp = 0
    (0 to 31).foreach(i => {
      temp = f(temp, i)
      val t = commonSetBits(temp)
      if (t == 1) res = f(res, i)
      temp = 0
    })
    res
  }

  private def f(n: Int, bit: Int): Int =
    n | (1 << bit)
}
