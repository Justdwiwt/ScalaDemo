package leetCode

import java.util.Scanner
import scala.collection.mutable

object MeiTuan_008 {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n = sc.nextInt()
    var x = sc.nextInt()
    var y = sc.nextInt()

    if (x == y) {
      println(0)
      return
    }

    val m = mutable.HashMap.empty[Int, Array[Int]]

    (1 until n).foreach(_ => {
      var n1 = sc.nextInt()
      var n2 = sc.nextInt()

      var arr = m.getOrElse(n1, Array.emptyIntArray)
      arr :+= n2
      m += n1 -> arr

      arr = m.getOrElse(n2, Array.emptyIntArray)
      arr :+= n1
      m += n2 -> arr
    })

    val visX = Array.fill(n + 1)(false)
    val visY = Array.fill(n + 1)(false)

    visX(x) = true
    visY(y) = true

    var todoX = List.empty[Int]
    var todoY = List.empty[Int]

    todoX ::= x
    todoY ::= y

    var cntY = 1
    var time = 0

    while (cntY > 0) {
      time += 1

      todoX.indices.foreach(_ => {
        val currX = todoX.head
        todoX = todoX.tail

        m(currX).withFilter(v => !visX(v)).foreach(v => {
          if (visY(v)) cntY -= 1
          todoX ::= v
          visX(v) = true
        })
      })

      if (todoY.nonEmpty) {
        todoY.indices.foreach(_ => {
          val currY = todoY.head
          todoY = todoY.tail

          m(currY).withFilter(v => !visY(v) && !visX(v)).foreach(v => {
            todoY ::= v
            visY(v) = true
            cntY += 1
          })
        })
      }
    }
    println(time)
  }
}
