data class Produkt(val nazwa: String, val cena: Double, val ilosc: Int)

class Koszyk
{
    val produkty = mutableListOf<Produkt>()
    
    fun dodaj(produkt: Produkt)
    {
        println("Dodano ${produkt.nazwa} za ${produkt.cena} x${produkt.ilosc} sztuk")
        produkty.add(produkt)
    }
    
    fun usun(nazwa: String)
    {
        println("Usunięto ${nazwa}")
        produkty.removeIf {it.nazwa == nazwa }
    }
    
    fun suma(): Double 
    {
        var suma = 0.0
        
        for(produkt in produkty)
        {
            suma += produkt.cena * produkt.ilosc
        }
        
        return when
        {
            suma > 200 -> suma * 0.9
            else -> suma
        }
    }
}

fun main() {
    val koszyk = Koszyk()

    koszyk.dodaj(Produkt("Chleb", 5.0, 2))
    koszyk.dodaj(Produkt("Mleko", 4.0, 3))
    koszyk.dodaj(Produkt("Laptop", 300.0, 1))
    koszyk.dodaj(Produkt("Woda 5l.", 10.0, 5))

    println("Suma: ${koszyk.suma()} zł")

    koszyk.usun("Mleko")

    println("Po usunięciu: ${koszyk.suma()} zł")
}
