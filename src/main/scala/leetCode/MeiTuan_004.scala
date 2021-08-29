package leetCode

import java.io.{BufferedReader, InputStreamReader}

object MeiTuan_004 {
  def main(args: Array[String]): Unit = {
    val sc = new BufferedReader(new InputStreamReader(System.in))
    val n = sc.readLine().toInt
    val a = Array.fill(2 * n)(-1)
    val b = Array.fill(2 * n)(-1)
    val nums = sc.readLine().split(" ")
    (0 until n).foreach(i => a(i) = nums(i).toInt)
    val cnt = sc.readLine().toInt
    (0 until cnt).foreach(_ => {
      val ops = sc.readLine().split(" ")
      if (ops.head.equals("2")) println(b(ops(1).toInt - 1))
      else System.arraycopy(a, ops(2).toInt - 1, b, ops(3).toInt - 1, ops(1).toInt)
    })
    sc.close()
  }
}
