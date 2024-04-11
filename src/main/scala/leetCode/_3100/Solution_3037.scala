package leetCode._3100

object Solution_3037 {
  abstract class InfiniteStream(bits: Array[Int]) {
    def next(): Int
  }

  def findPattern(infiniteStream: InfiniteStream, pattern: Array[Int]): Int = {
    val nex = get(pattern)
    var i = 0
    var j = 0
    var res = -1

    @scala.annotation.tailrec
    def f(): Int = {
      if (res != -1) res
      else {
        val num = infiniteStream.next()

        @scala.annotation.tailrec
        def g(): Unit = {
          if (j > 0 && num != pattern(j)) {
            j = nex(j - 1)
            g()
          }
        }

        g()
        if (num == pattern(j)) j += 1
        if (j == pattern.length) res = i - pattern.length + 1
        i += 1
        f()
      }
    }

    f()
  }

  private def get(str: Array[Int]): Array[Int] = {
    val n = str.length
    val ans = new Array[Int](n)

    @scala.annotation.tailrec
    def go(i: Int, j: Int): Unit = {
      if (i < str.length - 1)
        if (j > 0 && str(i) != str(j)) go(i, ans(j - 1))
        else if (str(i) == str(j)) {
          ans(i) = j + 1
          go(i + 1, j + 1)
        } else {
          ans(i) = 0
          go(i + 1, j)
        }
    }

    go(1, 0)
    ans
  }

}
