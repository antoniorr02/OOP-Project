require_relative "Deportistas"
require_relative "Corredor"

module Herencia

    deportista = Deportistas.new("Carlos", 0)
    puts deportista.competicion_deportiva(5) + "\n\n"

    corredor = Corredor.new(deportista)
    puts corredor.competicion_deportiva_completa

end