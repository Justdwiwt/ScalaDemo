package basic

import java.io.IOException
import java.net.{MalformedURLException, URL}

object FirstDemo {
  def main(args: Array[String]): Unit = {

    // for推导式
    // 生成的集合与它的第一个生成器是类型兼容的
    (1 to 3).foreach(i => (1 to 3).foreach(j => print(f"${10 * i + j}%3d")))
    (1 to 3).foreach(i => (1 to 3).withFilter(j => i != j).foreach(j => print(f"${10 * i + j}%3d")))
    (1 to 3).foreach(i => {
      val from = 4 - i
      (from to 3).foreach(j => print(f"${10 * i + j}%3d"))
    })
    (1 to 10).map(i => i % 3)
    "test".flatMap(c => (0 to 1).map(i => (c + i).toChar))
    (0 to 1).flatMap(i => "refactor".map(c => (c + i).toChar))

    println()
    box("refactor")

  }

  // 默认参数和带名参数
  def decorate(str: String, left: String = "[", right: String = "]"): String =
    left + str + right

  // 递归
  def recursiveSum(args: Int*): Int = {
    if (args.isEmpty) 0
    else args.head + recursiveSum(args.tail: _*)
  }

  // 无返回值的函数被称为过程，省略方法体前的=
  def box(s: String) {
    val border = "-" * (s.length + 2)
    print(f"$border%n|$s|%n$border%n")
  }

  // 懒值
  // val被声明为lazy时，初始化推迟，直到首次对它赋值
  lazy val words: String = scala.io.Source.fromFile("../src/main/scala").mkString

  // 异常
  // Scala没有受检异常，不需要声明函数或方法可能会抛出某种异常
  // throw由特殊的类型Nothing
  // 一个分支的类型是Nothing，那么表达式的类型就是另一个分支的类型
  val x = 5
  if (x >= 0) {
    recursiveSum(x)
  } else throw new IllegalArgumentException("x should not be negative")

  // 捕获异常使用模式匹配
  val url = new URL("http://horstmann.com/fred-tiny.gif")

  def process(url: URL): Unit = println(url)

  // 不需要使用捕获的异常对象，使用_来代替变量名
  try {
    process(url)
  } catch {
    case _: MalformedURLException => println(s"Bad URL: $url")
    case ex: IOException => ex.printStackTrace()
  }

}
