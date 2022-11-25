require_relative "Deportistas"
require_relative "Corredor_Nadador"

module Herencia

    deportista = Deportistas.new("Antonio", 0)
    puts deportista.competicion_deportiva(5) + "\n\n"

    corredor = Corredor_Nadador.new(deportista, "corredor")
    puts corredor.competicion_deportiva_completa(7)

    corredor = Corredor_Nadador.new(deportista, "nadador")
    puts corredor.competicion_deportiva_completa(7)

end