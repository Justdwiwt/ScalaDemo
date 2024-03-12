package leetCode._400

object Solution_381 {

  class RandomizedCollection() {

    private var arr = Array.empty[Int]

    def insert(`val`: Int): Boolean = {
      arr :+= `val`
      true
    }

    def remove(`val`: Int): Boolean = {
      if (arr.contains(`val`)) {
        arr.drop(arr.indexOf(`val`))
        return true
      }
      false
    }

    def getRandom: Int = arr(new util.Random().nextInt(arr.length))

  }

}
