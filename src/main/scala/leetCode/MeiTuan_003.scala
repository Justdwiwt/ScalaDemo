package leetCode

import java.util.Scanner

object MeiTuan_003 {
  def main(args: Array[String]): Unit = {
    val in = new Scanner(System.in)
    val n = in.nextInt()
    val m = in.nextInt()
    var arr = Array.fill(n, 3)(0)
    (0 until n).foreach(i => {
      arr(i)(0) = i + 1
      arr(i)(1) = in.nextInt()
      arr(i)(2) = in.nextInt()
    })
    arr = arr.sorted((o1: Array[Int], o2: Array[Int]) => {
      val a = o1(1) + o1(2) * 2
      val b = o2(1) + o2(2) * 2
      if (a == b) o1.head - o2.head
      b - a
    })
    var res = Array.fill(m)(0)
    (0 until m).foreach(i => res(i) = arr(i).head)
    res = res.sorted
    res.foreach(i => println(i + " "))
  }
}
