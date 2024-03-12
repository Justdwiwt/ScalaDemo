package leetCode._800

import scala.collection.mutable.ArrayBuffer

object Solution_749 {
  class Virus(r: Int, c: Int) {
    val row: Int = r
    val col: Int = c
    var cellsCovered = 0
    var wallsNeeded = 0
    var contained = false
    var cellsCanInfect: ArrayBuffer[Virus] = ArrayBuffer.empty[Virus]

    def addCellCanInfect(r: Int, c: Int): Unit =
      cellsCanInfect += new Virus(r, c)
  }

  def containVirus(grid: Array[Array[Int]]): Int = {
    val width = grid.head.length
    val height = grid.length

    val containedViruses = ArrayBuffer.empty[Virus]
    val unContainedViruses = ArrayBuffer.empty[Virus]

    findViruses(grid, unContainedViruses)

    var numContainedVirusCells = 0
    var numUnContainedVirusCells = 0
    val worldSize = width * height

    while (unContainedViruses.nonEmpty && numContainedVirusCells + numUnContainedVirusCells != worldSize) {
      numUnContainedVirusCells = growViruses(grid, unContainedViruses)
      containedViruses += removeBiggestVirus(unContainedViruses, grid)
      var newCellsContained = containedViruses.last.cellsCovered
      numContainedVirusCells += newCellsContained
      numUnContainedVirusCells -= newCellsContained
      removeJoinedViruses(grid, unContainedViruses)
    }

    var walls = 0
    containedViruses.foreach(v => walls += v.wallsNeeded)

    walls
  }

  def inValidCell(i: Int, j: Int, grid: Array[Array[Int]]): Boolean =
    i < 0 || j < 0 || i >= grid.length || j >= grid.head.length || grid(i)(j) == 8

  def findViruses(grid: Array[Array[Int]], vir: ArrayBuffer[Virus]): Unit = {
    val visited = Array.fill(grid.length, grid.head.length)(false)
    grid.indices.foreach(i => grid.head.indices.foreach(j => if (!visited(i)(j) && grid(i)(j) == 1) {
      val newVir = new Virus(i, j)
      vir += newVir
      markVirusCells(grid, i, j, visited)
    }))
  }

  def markVirusCells(grid: Array[Array[Int]], i: Int, j: Int, visited: Array[Array[Boolean]]): Unit = {
    if (inValidCell(i, j, grid) || visited(i)(j) || grid(i)(j) == 0) return
    visited(i)(j) = true
    markVirusCells(grid, i + 1, j, visited)
    markVirusCells(grid, i - 1, j, visited)
    markVirusCells(grid, i, j + 1, visited)
    markVirusCells(grid, i, j - 1, visited)
  }

  def growViruses(grid: Array[Array[Int]], vir: ArrayBuffer[Virus]): Int = {
    var unContainedVirusCells = 0
    vir.foreach(v => {
      v.cellsCanInfect.foreach(c => grid(c.row)(c.col) = 1)
      v.cellsCanInfect = ArrayBuffer.empty[Virus]
    })
    vir.foreach(v => {
      v.cellsCovered = 0
      v.wallsNeeded = 0
      visitVirus(grid, v.row, v.col, v, Array.fill(grid.length, grid.head.length)(false))
      unContainedVirusCells += v.cellsCovered
    })
    unContainedVirusCells
  }

  def visitVirus(grid: Array[Array[Int]], i: Int, j: Int, v: Virus, visited: Array[Array[Boolean]]): Unit = {
    if (inValidCell(i, j, grid)) return
    if (!visited(i)(j)) {
      visited(i)(j) = true
      if (grid(i)(j) == 0) v.addCellCanInfect(i, j)
      else {
        v.cellsCovered += 1
        visitVirus(grid, i + 1, j, v, visited)
        visitVirus(grid, i, j + 1, v, visited)
        visitVirus(grid, i - 1, j, v, visited)
        visitVirus(grid, i, j - 1, v, visited)
      }
    }
    if (grid(i)(j) == 0) v.wallsNeeded += 1
  }

  def removeBiggestVirus(vir: ArrayBuffer[Virus], grid: Array[Array[Int]]): Virus = {
    var biggestVirusIndex = 0
    var biggestVirusSize = 0
    vir.indices.foreach(i => {
      val v = vir(i)
      val growthSize = v.cellsCanInfect.length
      if (growthSize > biggestVirusSize) {
        biggestVirusIndex = i
        biggestVirusSize = growthSize
      }
    })
    containVirus(grid, vir(biggestVirusIndex))
    vir.remove(biggestVirusIndex)
  }

  def containVirus(grid: Array[Array[Int]], v: Virus): Unit = {
    containVirusHelper(grid, v.row, v.col)
    v.contained = true
  }

  def containVirusHelper(grid: Array[Array[Int]], i: Int, j: Int): Unit = {
    if (inValidCell(i, j, grid)) return
    if (grid(i)(j) == 1) {
      grid(i)(j) = 8
      containVirusHelper(grid, i, j + 1)
      containVirusHelper(grid, i + 1, j)
      containVirusHelper(grid, i - 1, j)
      containVirusHelper(grid, i, j - 1)
    }
  }

  def removeJoinedViruses(grid: Array[Array[Int]], vir: ArrayBuffer[Virus]): Unit = {
    val i: Iterator[Virus] = vir.iterator
    while (i.hasNext) {
      val v = i.next()
      if (grid(v.row)(v.col) == 8) i.drop(1)
    }
  }
}
