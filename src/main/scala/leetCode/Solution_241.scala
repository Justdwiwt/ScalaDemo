package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_241 {
  def diffWaysToCompute(input: String): List[Int] = {
    val symbols = mutable.Set("+", "-", "*")
    var in = Array.empty[String]
    var i = 0
    while (i < input.length) {
      if (symbols.contains(input.charAt(i) + "")) {
        in :+= (input.charAt(i) + "")
        i += 1
      } else {
        var j = i
        while (j < input.length && !symbols.contains(input.charAt(j) + "")) j += 1
        in :+= input.substring(i, j)
        i = j
      }
    }

    val g = (a: Int, b: Int, c: String) => c match {
      case "+" => a + b
      case "-" => a - b
      case _ => a * b
    }

    def f(start: Int, end: Int): List[Int] = {
      if (start == end) return List(in(start).toInt)
      if (start > end) return Nil
      if (start + 2 == end) return List(g(in(start).toInt, in(end).toInt, in(start + 1)))
      val ls = ListBuffer.empty[Int]
      (start to end)
        .withFilter(i => symbols.contains(in(i)))
        .foreach(i => {
          val left = f(start, i - 1)
          val right = f(i + 1, end)
          left.foreach(l => right.foreach(r => ls.append(g(l, r, in(i)))))
        })
      ls.toList
    }

    f(0, in.length - 1)

  }
}
