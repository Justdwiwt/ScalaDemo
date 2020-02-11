package structure

import scala.collection.mutable.ArrayBuffer

object SparseArray extends App {

  val chessMap = Array.ofDim[Int](11, 11)

  chessMap(1)(2) = 1
  chessMap(2)(3) = 2

  chessMap.foreach(i => {
    i.foreach(j => printf("%d\t", j))
    println()
  })

  val sparseArr = ArrayBuffer[Node]()
  chessMap.indices.foreach(i => chessMap(i).indices.foreach(j => {
    if (chessMap(i)(j) != 0) {
      val node = new Node(i, j, chessMap(i)(j))
      sparseArr.append(node)
    }
  }))

  sparseArr.foreach(i => printf("%d\t%d\t%d\n", i.row, i.col, i.value))

}


class Node(val row: Int, val col: Int, val value: Int)
