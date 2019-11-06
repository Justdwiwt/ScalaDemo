package leetCode

import scala.collection.mutable

object Solution_388 {

  case class Elem(level: Int, name: String) {
    def isFile: Boolean = name.contains('.')

    def getLength: Int = if (this.isFile) name.length else name.length + 1
  }

  def trans(str: String): Elem = {
    val name = str.replaceAll("\t", "")
    Elem(str.length - name.length, name)
  }

  def lengthLongestPath(input: String): Int = {
    var ans = 0
    val len = mutable.HashMap[Int, Int]()

    def f(elem: Elem): Unit = {
      len.put(elem.level, elem.getLength)
      if (elem.isFile) ans = ans max (0 to elem.level).map(len).sum
    }

    input.split("\n").map(trans).foreach(f)
    ans
  }

}
