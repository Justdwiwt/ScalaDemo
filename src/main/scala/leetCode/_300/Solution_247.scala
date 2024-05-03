package leetCode._300

object Solution_247 {
  def findStrobogrammatic(n: Int): List[String] = {
    val chars = new Array[Char](n)
    val ans = collection.mutable.ListBuffer.empty[String]
    val choices = Array("00", "11", "88", "69", "96")

    def f(i: Int, j: Int): Unit = {
      if (i > j) {
        if (n == 1 || chars(0) != '0') ans += new String(chars)
      } else choices.foreach(choice => {
        if (!(i == j && choice(0) != choice(1))) {
          chars(i) = choice(0)
          chars(j) = choice(1)
          f(i + 1, j - 1)
        }
      })
    }

    f(0, n - 1)
    ans.toList
  }
}
