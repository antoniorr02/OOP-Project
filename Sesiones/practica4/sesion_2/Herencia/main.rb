require_relative "Deportista"
require_relative "Corredor"
require_relative "Nadador"

module Herencia

    deportista = Deportista.new("Antonio", 3)
    puts deportista.to_s + "\n\n"
    puts deportista.competicion_deportiva

    corredor = Corredor.new(deportista)
    puts corredor.to_s
    puts corredor.competicion_deportiva

    nadador = Nadador.new(deportista)
    puts nadador.to_s

end