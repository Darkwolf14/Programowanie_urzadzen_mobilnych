data class Student(val imie: String, val punkty: Int, val email: String? = null, val grupa: String)

fun Student.czyZaliczyl() = punkty >= 50

fun ocena(punkty: Int): String = when {
    punkty >= 90 -> "5,0"
    punkty >= 75 -> "4,0"
    punkty >= 50 -> "3,0"
    else -> "2,0"
}

fun main() {
    val grupa = "IN1S5"              // val - stała, nie da się przypisać ponownie
    var licznik = 0                  // var - zmienna
    licznik += 1

    val studenci = listOf(
        Student("Ala", 92, "ala@student.pl", "IN1S5_P1"),
        Student("Bartek", 71, null,  "IN1S5_P2"),
        Student("Celina", 48, "celina@student.pl", "IN1S5_P2"),
    )

    println("Grupa $grupa, licznik = $licznik")
    for (s in studenci) {
        // ?. - bezpieczne wywołanie, ?: - wartość domyślna (operator Elvis)
        val domena = s.email?.substringAfter('@') ?: "brak e-maila"
        println("${s.imie.padEnd(7)} ${s.punkty} pkt -> ocena ${ocena(s.punkty)} ($domena)")
    }

    val zaliczeni = studenci.filter { it.czyZaliczyl() }.map { it.imie }
    val srednia = studenci.map { it.punkty }.average()
    println("Zaliczyli: $zaliczeni, średnia: ${"%.1f".format(srednia)} pkt")
    
    val grupy = studenci.groupBy{it.grupa}
    
    println("Srednia w grupach:")
    
    for((nazwa_grupy, studenci_w_grupie) in grupy)
    {
        val srednia_grupy = studenci_w_grupie.map{it.punkty}.average()
        
        println("\t$nazwa_grupy: " + "${"%.1f".format(srednia_grupy)} pkt")
    }

    val poprawiony = studenci[2].copy(punkty = 55) // data class: copy, equals, toString
    println(poprawiony)
}
