
object main {

  def patternMatching(x: String): String = x match {
    case x if List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek").contains(x) => "Praca"
    case x if List("Sobota", "Niedziela").contains(x) => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  case class Osoba(private var _imie: String, private var _nazwisko: String) {

    private var _podatek = 0.0

    def this(imie: String) {
      this(imie, "")
    }

    def this(imie: String, nazwisko: String, podatek: Double){
      this(imie, nazwisko)
      this._podatek = podatek
    }

    def ime = _imie
    def nazwisko = _nazwisko
    def podatek = _podatek


  }

  trait Student extends  Osoba{
    override def podatek = {
      0.0
    }
  }

  trait Nauczyciel extends Pracownik {
    override def podatek = {
      0.1*pensja
    }
  }

  trait Pracownik extends Osoba {
    var pensja = 0
    override def podatek = {
      0.2*pensja
    }
  }


  def classPatternMatching(x: Osoba): String = x match {
    case Osoba("Maciej", "Adamczyk") => "Hello my friend Maciej!"
    case Osoba("Igor", "Goryszewski") => "Igor has brought some pizza"
    case Osoba("Zuzanna", "Głowacz") => "Hi Zuzia, shall we play Among Us?"
    case Osoba("Filip", "Bartuzi") => "Oh no. An impostor (Filip)!"
    case _ => "I don't know you mate, bro! :("
  }

  def tripleCalculate(x: Int, f: Int => Int): Int = {
    f(f(f(x)))
  }

  def main(args: Array[String]): Unit = {
    // 1
    println("1.)")
    println(patternMatching("Poniedziałek"), patternMatching("Sobota"), patternMatching("Other"))
    // 2
    println("2.)")
    case class KontoBankowe(private var _stanKonta: Double) {

      def this() {
        this(0)
      }

      def stanKonta = _stanKonta

      def wplata(kwota: Double): Unit = {
        this._stanKonta += kwota
      }

      def wyplata(kwota: Double): Unit = {
        this._stanKonta -= kwota
      }
    }

    val konto = new KontoBankowe(100.0)
    println(konto)
    konto.wplata(100.0)
    println(konto)
    konto.wyplata(50.0)
    println(konto)
    // 3
    println("3.)")
    val list = List(
      new Osoba("Filip"),
      Osoba("Igor", "Goryszewski"),
      Osoba("Zuzanna", "Głowacz"),
      Osoba("Maciej", "Adamczyk"),
      Osoba("Bartek", "Wrona")
    )

    for (i: Int <- 0 until list.length) {
      println(classPatternMatching(list(i)))
    }

    // 4
    println("4.)")
    println(tripleCalculate(10, (x) => x + 20))
    // 5
    println("5.)")

    val osoba = new Osoba("Jan","Kowalski")
    val student = new Osoba("Jan","Kowalski") with Student
    val pracownik = new Osoba("Jan","Kowalski") with Pracownik
    pracownik.pensja = 100
    val nauczyciel = new Osoba("Jan","Kowalski") with Nauczyciel
    nauczyciel.pensja = 100
    val student_pracownik = new Osoba("Jan","Kowalski") with Student with Pracownik
    student_pracownik.pensja = 100
    val pracownik_student = new Osoba("Jan","Kowalski") with Pracownik with Student
    pracownik_student.pensja = 100

    println("Podatek:")
    println("osoba:",osoba.podatek)
    println("student:",student.podatek)
    println("pracownik:",pracownik.podatek)
    println("nauczyciel:",nauczyciel.podatek)
    println("student_pracownik:",student_pracownik.podatek) // ciekawe (od prawej strony bierze :))
    println("pracownik_student:",pracownik_student.podatek) // ciekawe
  }
}
