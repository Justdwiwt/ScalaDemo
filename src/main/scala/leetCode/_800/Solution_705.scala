package leetCode._800

object Solution_705 {

  class MyHashSet() {

    val arr = new Array[Boolean](1000000)

    def add(key: Int) {
      arr(key) = true
    }

    def remove(key: Int) {
      arr(key) = false
    }

    def contains(key: Int): Boolean = arr(key)

  }

}
