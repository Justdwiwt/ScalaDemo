package leetCode

import scala.math.Integral.Implicits._

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

  def wordCount(list: List[String]): List[(String, Int)] = {
    list.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.length)).toList.sortBy(_._2).reverse
  }

  def tuple2ToList[T](t: (T, T)): List[T] = List(t._1, t._2)

  def powMod(base: Int, pow: Int, mod: Int): Int = {
    @scala.annotation.tailrec
    def dfs(base: Long, pow: Int, res: Long): Int =
      if (pow == 0) res.toInt
      else if (pow % 2 == 0) dfs((base * base) % mod, pow / 2, res)
      else dfs((base * base) % mod, pow / 2, (res * base) % mod)

    dfs(base, pow, res = 1L)
  }

  @scala.annotation.tailrec
  def gcd[T: Integral](a: T, b: T): T =
    if (b == 0) a else gcd(b, a % b)

  def lcm[T: Integral](a: T, b: T): T =
    a / gcd(a, b) * b

  def bisectLeft(nums: collection.Seq[Int], n: Int): Int = {
    @scala.annotation.tailrec
    def dfs(l: Int, r: Int): Int =
      if (l >= r) l
      else {
        val mid = (l + r) >>> 1
        if (nums(mid) < n) dfs(mid + 1, r)
        else dfs(l, mid)
      }

    dfs(l = 0, r = nums.length)
  }

  def characterCounts(s: String, upper: Boolean = false): Seq[Int] = {
    val (start, end) = if (upper) ('A'.toInt, 'Z'.toInt) else ('a'.toInt, 'z'.toInt)
    val asciiOffset = start
    val charCountLength = end - asciiOffset + 1
    val charCounts = Array.fill(charCountLength)(0)
    s.foreach(char => charCounts(char.toInt - asciiOffset) += 1)
    charCounts.toSeq
  }

  def neighbours[T](x: Int, y: Int, grid: Array[Array[T]]): Seq[(Int, Int)] = Seq((-1, 0), (0, -1), (0, 1), (1, 0)).collect {
    case (dx, dy) if x + dx >= 0 && x + dx < grid.length && y + dy >= 0 && y + dy < grid.head.length => (x + dx, y + dy)
  }

  def isPalindrome(s: String): Boolean = {
    @scala.annotation.tailrec
    def dfs(l: Int, r: Int): Boolean =
      l >= r || (s(l) == s(r) && dfs(l + 1, r - 1))

    dfs(l = 0, r = s.length - 1)
  }

  def sieveOfEratosthenes(n: Int): Seq[Int] = {
    val arr = Array.tabulate(n)(i => i)
    (2 to math.sqrt(n).toInt).foreach(i => if (arr(i) == i) (i * i until n by i).foreach(j => if (arr(j) > i) arr(j) = i))
    arr.toSeq
  }

  def seqToLinkedList(elements: Seq[Int]): ListNode =
    elements.:\[ListNode](null)((value, next) => new ListNode(value, next))

  def linkedListToSeq(head: ListNode): Seq[Int] =
    if (head == null) Seq.empty
    else head.x +: linkedListToSeq(head.next)

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = Nil
  }
}
