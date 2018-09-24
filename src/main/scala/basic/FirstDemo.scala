package basic

object FirstDemo {
  def main(args: Array[String]): Unit = {

    // for推导式
    // 生成的集合与它的第一个生成器是类型兼容的
    for (i <- 1 to 3; j <- 1 to 3)
      print(f"${10 * i + j}%3d")
    for (i <- 1 to 3; j <- 1 to 3 if i != j)
      print(f"${10 * i + j}%3d")
    for (i <- 1 to 3; from = 4 - i; j <- from to 3)
      print(f"${10 * i + j}%3d")
    for (i <- 1 to 10)
      yield i % 3
    for (c <- "test"; i <- 0 to 1)
      yield (c + i).toChar
    for (i <- 0 to 1; c <- "refactor")
      yield (c + i).toChar
  }
}
