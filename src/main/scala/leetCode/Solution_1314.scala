package leetCode

object Solution_1314 {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = mat
    .map(f(_, K))
    .transpose
    .map(f(_, K))
    .transpose

  def f(line: Array[Int], k: Int): Array[Int] = {
    val newLine = Array.fill(line.length)(0)
    val kPlus1 = k + 1
    newLine(0) = line.take(kPlus1).sum
    line.indices.drop(1).foreach(i => {
      newLine(i) = newLine(i - 1)
      if (i - kPlus1 >= 0) newLine(i) -= line(i - kPlus1)
      if (i + k < line.length) newLine(i) += line(i + k)
    })
    newLine
  }
}
