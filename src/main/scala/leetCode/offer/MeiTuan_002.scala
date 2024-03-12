package leetCode.offer

import java.io.{BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter}
import java.util
import scala.util.control.Breaks._

//noinspection ComparingUnrelatedTypes
object MeiTuan_002 {
  def main(args: Array[String]): Unit = {
    val tm = new util.TreeMap[Int, Int]()
    val ts = new util.TreeSet[Int]()
    val prefix = Array.fill(50050)(0)

    val br = new BufferedReader(new InputStreamReader(System.in))
    val bw = new BufferedWriter(new OutputStreamWriter(System.out))

    val n = br.readLine().toInt
    val arr = br.readLine().split(" ")
    val query = br.readLine().split(" ")

    br.close()

    (0 until n).foreach(i => prefix(i + 1) = prefix(i) + arr(i).toInt)

    ts.add(0)
    ts.add(n + 1)

    (0 until n).foreach(i => {
      val pos = query(i).toInt
      val left = ts.lower(pos)
      val right = ts.higher(pos)

      breakable(if (left == null || right == null) break())

      val segSum = prefix(right - 1) - prefix(left)
      val v = tm.get(segSum)

      if (v != null) {
        if (v == 1) tm.remove(segSum)
        else tm.put(segSum, v - 1)
      }

      val leftSum = prefix(pos - 1) - prefix(left)
      val rightSum = prefix(right - 1) - prefix(pos)

      ts.add(pos)
      tm.put(leftSum, tm.getOrDefault(leftSum, 0) + 1)
      tm.put(rightSum, tm.getOrDefault(right, 0) + 1)

      bw.write(tm.lastKey() + "\n")
    })
    bw.close()
  }
}
