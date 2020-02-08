package leetCode

object Common {

  def lowerBound(xs: Array[Int], x: Int): Int = {

    @scala.annotation.tailrec
    def loop(first: Int, count: Int): Int = {
      if (count == 0) first
      else {
        val step = count / 2
        if (xs(first + step) < x) loop(first + step + 1, count - step - 1)
        else loop(first, step)
      }
    }

    loop(0, xs.length)
  }

  def upperBound(xs: Array[Int], x: Int): Int = {
    @scala.annotation.tailrec
    def loop(first: Int, count: Int): Int = {
      if (count == 0) first
      else {
        val step = count / 2
        if (x < xs(first + step)) loop(first, step)
        else loop(first + step + 1, count - step - 1)
      }
    }

    loop(0, xs.length)
  }

  def swap[T, S](tup: (T, S)): Any = tup match {
    case (x, y) => (y, x)
    case _ => println("error")
  }

  def swapFS(arr: Array[Any]): Array[Any] = arr match {
    case Array(fir, sec, rest@_*) => Array(sec, fir) ++ rest
    case _ => arr
  }

  def ip2Long(ip: String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    (0 until fragments.length).foreach(i => ipNum = fragments(i).toLong | ipNum << 8L)
    ipNum
  }

  def binarySearchIP(lines: Array[(Long, Long, String)], ip: Long): Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high) / 2
      if ((ip >= lines(middle)._1) && (ip <= lines(middle)._2)) return middle
      if (ip < lines(middle)._1) high = middle - 1
      else low = middle + 1
    }
    -1
  }

}
