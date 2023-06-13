package cinema

fun main() {
    //Fase donde se establece el tamaño de la sala.
    println("Enter the number of rows:")
    val filas = readln().toInt()
    println("Enter the number of seats in each row:")
    val columnas = readln().toInt()
    val asientos = MutableList(filas) {MutableList(columnas) {"S"} }

    //bucle del programa
    var continuidad = true
    while (continuidad) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        when (readln().toInt()) {
            1 -> imprimirTablero(asientos)
            2 -> comprarBoletos(filas, columnas, asientos)
            3 -> estadisticas(asientos)
            0 -> continuidad = false
        }

    }
}

fun estadisticas(asientos: MutableList<MutableList<String>>) {
    var cantidadBoletosComprados = 0
    var ingresoActual = 0
    var ingresoTotal = 0

    for (i in asientos.indices) {
        val fila = asientos[i]
        for (j in fila.indices) {
            val asiento = fila[j]
            if (asiento == "B") {
                cantidadBoletosComprados++
                ingresoActual += precioAsiento(asientos.size, asientos[0].size, i + 1)
            }
            ingresoTotal += precioAsiento(asientos.size, asientos[0].size, i + 1)
        }
    }

    val porcentajeAsientosVendidos: Float = 100 * cantidadBoletosComprados.toFloat() / (asientos.size * asientos[0].size).toFloat()
    val formatoPorcentaje = "%.2f".format(porcentajeAsientosVendidos)

    println("Number of purchased tickets: $cantidadBoletosComprados")
    println("Percentage: $formatoPorcentaje%")
    println("Current income: $$ingresoActual")
    println("Total income: $$ingresoTotal")
}

private fun comprarBoletos(
    filas: Int,
    columnas: Int,
    asientos: MutableList<MutableList<String>>
) {
    println("Enter a row number:")
    val asientoFila = readln().toInt()
    println("Enter a seat number in that row:")
    val asientoColumna = readln().toInt()

    if (asientoFila > filas || asientoColumna > columnas) {
        println("Wrong input!\n")
        comprarBoletos(filas, columnas, asientos)
    }
    else {
        if (asientos[asientoFila - 1][asientoColumna - 1] == "B") {
            print("That ticket has already been purchased!\n")
            comprarBoletos(filas, columnas, asientos)
        }
        else {
            println("Ticket price: $${precioAsiento(filas, columnas, asientoFila)}")
            asientos[asientoFila - 1][asientoColumna - 1] = "B"
        }
    }
}

private fun precioAsiento(filas: Int, columnas: Int, asientoFila: Int): Int {
    val precioAsiento = if (filas * columnas <= 60) {
        10
    } else {
        if (asientoFila <= filas / 2) {
            10
        } else {
            8
        }
    }
    return precioAsiento
}

private fun imprimirTablero(
    asientos: MutableList<MutableList<String>>
) {
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