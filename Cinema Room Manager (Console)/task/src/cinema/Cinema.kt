package cinema

fun main() {
    println("Enter the number of rows:")
    val filas = readln().toInt()
    println("Enter the number of seats in each row:")
    val columnas = readln().toInt()
    val asientos = MutableList(filas) {MutableList(columnas) {"S"} }
    imprimirTablero(asientos)

    println("Enter a row number:")
    val asientoFila = readln().toInt()
    println("Enter a seat number in that row:")
    val asientoColumna = readln().toInt()

    val precioAsiento = if (filas * columnas <= 60) {
        10
    } else {
        if (asientoFila <= filas/2) {
            10
        } else {
            8
        }
    }
    println("Ticket price: $${precioAsiento}")
    asientos[asientoFila - 1][asientoColumna - 1] = "B"
    imprimirTablero(asientos)
}

private fun imprimirTablero(asientos: MutableList<MutableList<String>>) {
    println("\nCinema:")
    print(" ")
    for (i in asientos[0].indices) {
        print(" ${i + 1}")
    }
    println("")
    for (i in asientos.indices) {
        print("${i + 1}")
        for (j in asientos[i].indices) {
            print(" ${asientos[i][j]}")
        }
        println("")
    }
    println("\n")
}