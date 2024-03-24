package leetCode._1700

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1604 {
  def alertNames(keyName: Array[String], keyTime: Array[String]): List[String] = {
    val m = mutable.HashMap.empty[String, ArrayBuffer[Int]]

    def _strTime(time: String): Int = {
      val a = time.split(":")
      a.head.toInt * 60 + a(1).toInt
    }

    keyName.zip(keyTime).foreach { case (name, time) =>
      if (!m.contains(name)) m += (name -> new ArrayBuffer[Int])
      m(name) += _strTime(time)
    }

    def f(arr: Array[Int]): Boolean = {
      (0 to arr.length - 3).foreach(i => if (arr(i + 2) - arr(i) <= 60) return true)
      false
    }

    m
      .filter { case (_, arr) => if (arr.length < 3) false else f(arr.sortWith(_ < _).toArray) }
      .map { case (name, _) => name }
      .toList
      .sortWith(_ < _)
  }
}
