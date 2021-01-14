object ex1 {
  def func_of_generators = for {
    c <- Iterator.from(1) //generator
    a <- 1 to c if c%a == 0 //filter
  } yield(c,a)

  def main(args: Array[String]): Unit = {
    val test = func_of_generators.buffered
    println(test.next)
    println(test.next)
    println(test.next)
    func_of_generators take 17 foreach println
  }
}
